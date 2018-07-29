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
    List<Class> moves;
    String name;
    IBattleLogger logger;

    public Pokemon(String name){
        this.name = name;
        this.preBattleStates = new ArrayList<>();
        this.postBattleStates = new ArrayList<>();
        this.moves = MoveDatabase.getAttackStateFor(name);
        this.shouldSelectMove = true;
        this.logger = FacadeFactory.getInstance(IBattleLogger.class);
        this.moveGetter = FacadeFactory.getInstance(IChooseMove.class);
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
    private void setAttackState(Class attackStateClass){
        try {
            attackState = (AttackState) attackStateClass.newInstance();
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
