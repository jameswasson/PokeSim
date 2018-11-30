package Pokemons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import AttackStates.AttackState;
import AttackStates.Move;
import BattleField.IBattleLogger;
import BattleStates.BattleState;
import Facade.FacadeFactory;
import Utils.SelectMove.IChooseMove;

public class BasePokemon extends Pokemon{

    IChooseMove moveGetter;
    boolean shouldSelectMove;
    List<BattleState> preBattleStates;
    AttackState attackState;
    List<BattleState> postBattleStates;
    List<Move> moves;
    IBattleLogger logger;

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

    public int getLevel(){
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
    public void loseHP(int HPLoss){
        curHP -= HPLoss;
        curHP = Math.max(0,curHP);//if negative, make zero
    }
    public void gainHP(int HPGain){
        int amountAbleToGain = HP - curHP;
        int amountToGain = Math.min(amountAbleToGain, HPGain);
        curHP += amountToGain;
    }
    public boolean hasFainted(){
        return curHP == 0;
    }
    public void changeATK(int stage){
        ATKStage =  StageIncrementer.incrementBy("Attack", ATKStage, stage, name);
    }
    public void changeSPD(int stage){
        SPDStage =  StageIncrementer.incrementBy("Speed", SPDStage, stage, name);
    }
    public void changeDEF(int stage){
        DEFStage =  StageIncrementer.incrementBy("Defence", DEFStage, stage, name);
    }
    public void changeSPC(int stage){
        SPCStage =  StageIncrementer.incrementBy("Special", SPCStage, stage, name);
    }
    public void changeACC(int stage){
        ACCStage =  StageIncrementer.incrementBy("Accuracy", ACCStage, stage, name);
    }
    public void changeEVA(int stage){
        EVAStage =  StageIncrementer.incrementBy("Evasiveness", EVAStage, stage, name);
    }

    public int getPokedexNo(){
        return pokedexNo;
    }
    public int getBaseHP(){
        return HP;
    }
    public int getBaseATK(){
        return ATK;
    }
    public int getBaseSPC(AttackState move){
        return SPC;
    }
    public int getBaseSPD(){
        return SPD;
    }
    public int getBaseDEF(AttackState move) { return DEF;}
    public int getCurHP(){
        return curHP;
    }
    public int getCurATK(){
        return (int)(getBaseATK()*StageIncrementer.getStatMultiplier(ATKStage));
    }
    public int getCurDEF(AttackState move){
        return (int)(getBaseDEF(move)*StageIncrementer.getStatMultiplier(SPCStage));
    }
    public int getCurSPC(AttackState move){
        return (int)(getBaseSPC(move)*StageIncrementer.getStatMultiplier(SPCStage));
    }
    public int getCurSPD(){
        return (int)(getBaseSPD()*StageIncrementer.getStatMultiplier(SPDStage));
    }
    public int getCurACC(){
        return (int)(StageIncrementer.getStatMultiplierAccEva(ACCStage));
    }
    public int getCurEVA(){
        return (int)(StageIncrementer.getStatMultiplierAccEva(-EVAStage));
    }
    public boolean isType(EleType type){
        return type == type1 || type == type2;
    }
    public void setType1(EleType type1) {
        this.type1 = type1;
    }
    public void setType2(EleType type2) {
        this.type2 = type2;
    }

    public BasePokemon(int pokedexNo, String name, EleType type1, EleType type2, int HP, int ATK, int DEF, int SPC, int SPD, List<Move> moves) {
        this.pokedexNo = pokedexNo;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPC = SPC;
        this.SPD = SPD;
        this.curHP = HP;
        this.ATKStage = 0;
        this.DEFStage = 0;
        this.SPCStage = 0;
        this.SPDStage = 0;
        this.moves = moves;
        this.preBattleStates = new ArrayList<>();
        this.postBattleStates = new ArrayList<>();
        this.shouldSelectMove = true;
        this.logger = FacadeFactory.getInstance(IBattleLogger.class);
        this.moveGetter = FacadeFactory.getInstance(IChooseMove.class);
    }
    public static BasePokemon copyBasePokemon(BasePokemon bp){
        //copy moves here
        List<Move> newMoves = new ArrayList<>();
        for (Move move: bp.moves)
            newMoves.add(Move.copyMove(move));
        return new BasePokemon(bp.pokedexNo,bp.name,bp.type1,bp.type2,bp.HP,bp.ATK,bp.DEF,bp.SPC,bp.SPD,newMoves);
    }

    public BasePokemon getBasePokemon() {
        return this;
    }

    public void selectMove(){
        if (!shouldSelectMove)
            return;
        logger.println("Select a move for " + name + ":");
        List<Integer> noPPMoves = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            logger.print("(" + (i + 1) + "): " + AttackState.getName(move.getClass()));
            logger.println(" (" + move.getCurrentPowerPoints() + "/" + move.getPowerPoints() + ")");
            if (move.getCurrentPowerPoints() == 0)
                noPPMoves.add(i + 1);
        }
        int selection = moveGetter.getMove(moves.size(), noPPMoves) - 1;
        setAttackState(moves.get(selection));
    }
    public void selectMove(int moveIndex){
        if (!shouldSelectMove)
            return;
        if (moveIndex < moves.size()){
            setAttackState(moves.get(moveIndex));
        }
    }
    public void attack(Pokemon toAttack){
        attackState.execute(this, toAttack);
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
    public int getDEF(AttackState move){return DEF;}
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
}