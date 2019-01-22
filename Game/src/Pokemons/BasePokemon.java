package Pokemons;

import AttackStates.AttackState;
import AttackStates.Move;
import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Utils.SelectMove.IChooseMove;

import java.util.ArrayList;
import java.util.List;

public class BasePokemon extends Pokemon {

    IChooseMove moveGetter;
    boolean shouldSelectMove;
    List<BattleState> preBattleStates;
    AttackState attackState;
    List<BattleState> postBattleStates;
    List<Move> moves;

    int pokedexNo;
    String name;
    EleType type1;
    EleType type2;
    int HP;
    int ATK;
    int SPD;
    int DEF;
    int SPC;
    int curHP;
    int ATKStage;
    int SPDStage;
    int DEFStage;
    int SPCStage;
    int ACCStage;
    int EVAStage;
    int critBonus;

    @Override
    public void setBasePokemon(Pokemon pokemon) {
        logger.println("ERROR! BASEPOKEMON TOLD TO SETBASEPOKEMON");
    }

    public int getLevel() {
        return 100;// assume 100 for now
    }

    public void setATKStage(int ATKStage) {
        this.ATKStage = ATKStage;
    }

    public void setSPDStage(int SPDStage) {
        this.SPDStage = SPDStage;
    }

    public void setDEFStage(int DEFStage) {
        this.DEFStage = DEFStage;
    }

    public void setSPCStage(int SPCStage) {
        this.SPCStage = SPCStage;
    }

    public void setACCStage(int ACCStage) {
        this.ACCStage = ACCStage;
    }

    public void setEVAStage(int EVAStage) {
        this.EVAStage = EVAStage;
    }

    public EleType getType1() {
        return type1;
    }

    public EleType getType2() {
        return type2;
    }

    public void loseHP(int HPLoss) {
        curHP -= HPLoss;
        curHP = Math.max(0, curHP);//if negative, make zero
    }

    public void gainHP(int HPGain) {
        int amountAbleToGain = HP - curHP;
        int amountToGain = Math.min(amountAbleToGain, HPGain);
        curHP += amountToGain;
    }

    public boolean hasFainted() {
        return curHP == 0;
    }

    public void changeATK(int stage) {
        ATKStage = StageIncrementer.incrementBy("Attack", ATKStage, stage, name);
    }

    public void changeSPD(int stage) {
        SPDStage = StageIncrementer.incrementBy("Speed", SPDStage, stage, name);
    }

    public void changeDEF(int stage) {
        DEFStage = StageIncrementer.incrementBy("Defence", DEFStage, stage, name);
    }

    public void changeSPC(int stage) {
        SPCStage = StageIncrementer.incrementBy("Special", SPCStage, stage, name);
    }

    public void changeACC(int stage) {
        ACCStage = StageIncrementer.incrementBy("Accuracy", ACCStage, stage, name);
    }

    public void changeEVA(int stage) {
        EVAStage = StageIncrementer.incrementBy("Evasiveness", EVAStage, stage, name);
    }

    public int getPokedexNo() {
        return pokedexNo;
    }

    public int getBaseHP() {
        return HP;
    }

    public int getBaseATK() {
        return ATK;
    }

    public int getBaseSPC(AttackState move) {
        return SPC;
    }

    public int getBaseSPD() {
        return SPD;
    }

    public int getBaseDEF(AttackState move) {
        return DEF;
    }

    public int getCurHP() {
        return curHP;
    }

    public int getCurATK() {
        return (int) (getBaseATK() * StageIncrementer.getStatMultiplier(ATKStage));
    }

    public int getCurDEF(AttackState move) {
        return (int) (getBaseDEF(move) * StageIncrementer.getStatMultiplier(SPCStage));
    }

    public int getCurSPC(AttackState move) {
        return (int) (getBaseSPC(move) * StageIncrementer.getStatMultiplier(SPCStage));
    }

    public int getCurSPD() {
        return (int) (getBaseSPD() * StageIncrementer.getStatMultiplier(SPDStage));
    }

    public int getCurACC() {
        return (int) (StageIncrementer.getStatMultiplierAccEva(ACCStage));
    }

    public int getCurEVA() {
        return (int) (StageIncrementer.getStatMultiplierAccEva(-EVAStage));
    }

    public boolean isType(EleType type) {
        return type == type1 || type == type2;
    }

    public void setType1(EleType type1) {
        this.type1 = type1;
    }

    public void setType2(EleType type2) {
        this.type2 = type2;
    }

    public BasePokemon(String name) {
        List<String> pokeInfo = Pokedex.getPokemonInfo(name);
        this.type1 = TypesHelper.enumOf(pokeInfo.get(1));
        this.type2 = TypesHelper.enumOf(pokeInfo.get(2));
        this.HP = Integer.valueOf(pokeInfo.get(3));
        this.ATK = Integer.valueOf(pokeInfo.get(4));
        this.DEF = Integer.valueOf(pokeInfo.get(5));
        this.SPC = Integer.valueOf(pokeInfo.get(6));
        this.SPD = Integer.valueOf(pokeInfo.get(7));
        this.moves = new ArrayList<>();
        for (int i = 8; i < pokeInfo.size(); i++) {
            this.moves.add(Move.getMove(pokeInfo.get(i)));
        }

        this.name = name;
        this.curHP = this.HP;
        this.ATKStage = 0;
        this.DEFStage = 0;
        this.SPCStage = 0;
        this.SPDStage = 0;
        this.critBonus = 1;
        this.preBattleStates = new ArrayList<>();
        this.postBattleStates = new ArrayList<>();
        this.shouldSelectMove = true;
        this.moveGetter = FacadeFactory.getInstance(IChooseMove.class);
    }

    public BasePokemon getBasePokemon() {
        return this;
    }

    public void selectMove() {
        if (!shouldSelectMove)
            return;
        logger.println("Select a move for " + name + ":");
        List<Integer> noPPMoves = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            logger.println("(" + (i + 1) + "): " + move.getDisplayText());
            if (move.getCurrentPowerPoints() == 0)
                noPPMoves.add(i + 1);
        }
        int selection = moveGetter.getMove(moves.size(), noPPMoves) - 1;
        setAttackState(moves.get(selection));
    }

    public void selectMove(int moveIndex) {
        if (!shouldSelectMove)
            return;
        if (moveIndex < moves.size()) {
            setAttackState(moves.get(moveIndex));
        }
    }

    public void selectMove(Class<?> moveClass) {
        attackState = Move.getMove(moveClass.getSimpleName());
    }

    public void attack(Pokemon toAttack) {
        attackState.execute(this, toAttack);
    }

    public String getName() {
        return name;
    }

    public void runPreBattleStates() {
        logger.println("ERROR!");
    }

    public void runPostBattleStates() {
        logger.println("ERROR!");
    }

    public void runPreBattleStates(Pokemon pokemon) {
        for (BattleState preState : preBattleStates)
            preState.execute(pokemon);
    }

    public void runPostBattleStates(Pokemon pokemon) {
        for (BattleState postState : postBattleStates)
            postState.execute(pokemon);
    }

    public AttackState getAttackState() {
        return attackState;
    }

    public void setAttackState(Class<?> attackStateClass) {
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

    public void setShouldSelectMove(boolean shouldSelectMove) {
        this.shouldSelectMove = shouldSelectMove;
    }

    public List<BattleState> getPreBattleStates() {
        return preBattleStates;
    }

    public List<BattleState> getPostBattleStates() {
        return postBattleStates;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getATK() {
        return ATK;
    }

    public int getSPD() {
        return SPD;
    }

    public int getDEF(AttackState move) {
        return DEF;
    }

    public int getSPC() {
        return SPC;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public void setSPD(int SPD) {
        this.SPD = SPD;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void setSPC(int SPC) {
        this.SPC = SPC;
    }

    public double getCritBonus() {
        return critBonus;
    }

    public void setCritBonus(int bonus) {
        this.critBonus = bonus;
    }
}
