package Pokemons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import AttackStates.AttackState;
import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Pokemons.MoveDatabase.MoveDatabase;
import Utils.Helpers;
import Utils.SelectMove.IChooseMove;

import javax.swing.table.AbstractTableModel;

public class Pokemon implements IPokemon{
    IChooseMove moveGetter;
    boolean shouldSelectMove;
    List<BattleState> preBattleStates;
    AttackState attackState;
    List<BattleState> postBattleStates;
    List<Class<?>> moves;
    IBattleLogger logger;

    int pokedexNo;
    String name;
    EleType type1;
    EleType type2;
    int HP;
    int ATK;
    int DEF;
    int SPC;
    int SPD;

    public int getPokedexNo(){
        return pokedexNo;
    }
    public int getBaseHP(){
        return HP;
    }
    public int getBaseATK(){
        return ATK;
    }
    public int getBaseDEF() {
        return DEF;
    }
    public int getBaseSPC(){
        return SPC;
    }
    public int getBaseSPD(){
        return SPD;
    }
    public int getCurHP(){
        //todo change
        return getBaseHP();
    }
    public int getCurATK(){
        //todo change
        return getBaseATK();
    }
    public int getCurDEF(){
        //todo change
        return getBaseDEF();
    }
    public int getCurSPC(){
        //todo change
        return getBaseSPC();
    }
    public int getCurSPD(){
        //todo change
        return getBaseSPD();
    }
    public boolean isType(EleType type){
        return type == type1 || type == type2;
    }

    public Pokemon(int pokedexNo, String name, EleType type1, EleType type2, int HP, int ATK, int DEF, int SPC, int SPD, List<Class<?>> moves) {
        this.pokedexNo = pokedexNo;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPC = SPC;
        this.SPD = SPD;
        this.moves = moves;
        this.preBattleStates = new ArrayList<>();
        this.postBattleStates = new ArrayList<>();
        this.shouldSelectMove = true;
        this.logger = FacadeFactory.getInstance(IBattleLogger.class);
        this.moveGetter = FacadeFactory.getInstance(IChooseMove.class);
    }
    public static Pokemon copyPokemon(Pokemon pokemon){
        return new Pokemon(pokemon.pokedexNo,pokemon.name,pokemon.type1,pokemon.type2,pokemon.HP,pokemon.ATK,pokemon.DEF,pokemon.SPC,pokemon.SPD,pokemon.moves);
    }

    public void selectMove(){
        if (!shouldSelectMove)
            return;
        logger.println("Select a move for " + name + ":");
        for (int i = 0; i < moves.size(); i++){
            logger.println("(" + (i + 1) + "): " + AttackState.getName(moves.get(i)));
        }
        int selection = moveGetter.getMove(moves.size()) - 1;
        setAttackState(moves.get(selection));
    }
    public void selectMove(int moveIndex){
        if (!shouldSelectMove)
            return;
        if (moveIndex < moves.size()){
            setAttackState(moves.get(moveIndex));
        }
    }
    public void attack(IPokemon toAttack){
        attackState.execute(this,(Pokemon)toAttack);
        attackState = null;
    }
    public String getName(){
        return name;
    }
    public void runPreBattleStates(){
        shouldSelectMove = true;//any state should be able to change this
        for (Iterator<BattleState> iterator = preBattleStates.iterator(); iterator.hasNext();){
            BattleState nextBattleState = iterator.next();
            boolean shouldRemove = nextBattleState.execute(this);
            if (shouldRemove)
                iterator.remove();
        }
    }
    public void runPostBattleStates(){
        for (Iterator<BattleState> iterator = postBattleStates.iterator(); iterator.hasNext();){
            BattleState nextBattleState = iterator.next();
            boolean shouldRemove = nextBattleState.execute(this);
            if (shouldRemove)
                iterator.remove();
        }
    }

    public AttackState getAttackState() {
        return attackState;
    }
    private void setAttackState(Class<?> attackStateClass){
        try {
            attackState = (AttackState) attackStateClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setAttackState(AttackState attackState) {
        this.attackState = attackState;
    }
    public void addPostBattleState(BattleState battleState) {
        postBattleStates.add(battleState);
    }
    public void setShouldSelectMove(boolean shouldSelectMove){
        this.shouldSelectMove = shouldSelectMove;
    }
    public List<BattleState> getPreBattleStates() {
        return preBattleStates;
    }
}
