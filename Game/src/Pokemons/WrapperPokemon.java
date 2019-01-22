package Pokemons;

import AttackStates.AttackState;
import AttackStates.Move;
import BattleStates.BattleState;

import java.util.List;

public class WrapperPokemon extends Pokemon {

    Pokemon wrappedPokemon;

    public static void wrap(Pokemon toWrap, WrapperPokemon wrapper){
        Pokemon inner = toWrap.getWrappedPokemon();
        wrapper.setWrappedPokemon(inner);
        toWrap.setWrappedPokemon(wrapper);
    }

    public void setHead(Pokemon head){
        wrappedPokemon.setHead(head);
    }

    public Pokemon getHead(){
        return wrappedPokemon.getHead();
    }

    public void removeSelf(){
        Pokemon cur = wrappedPokemon.getHead();
        while (cur.getWrappedPokemon() != this && cur.getWrappedPokemon() != null){
            cur = cur.getWrappedPokemon();
        }
        if (cur.getWrappedPokemon() == null){
            logger.println("Self not found!");
        }
        else{
            cur.setWrappedPokemon(getWrappedPokemon());
        }
    }

    public void setWrappedPokemon(Pokemon pokemon) {
        this.wrappedPokemon = pokemon;
    }

    public Pokemon getWrappedPokemon(){
        return wrappedPokemon;
    }

    public BasePokemon getBasePokemon() {
        return wrappedPokemon.getBasePokemon();
    }

    public WrapperPokemon() {
    }

    public WrapperPokemon(BasePokemon pokemon) {
        wrappedPokemon = pokemon;
        wrappedPokemon.setHead(this);
    }

    public int getLevel() {
        return wrappedPokemon.getLevel();
    }

    public void setATKStage(int ATKStage) {
        wrappedPokemon.setATKStage(ATKStage);
    }

    public void setSPDStage(int SPDStage) {
        wrappedPokemon.setSPDStage(SPDStage);
    }

    public void setDEFStage(int DEFStage) {
        wrappedPokemon.setDEFStage(DEFStage);
    }

    public void setSPCStage(int SPCStage) {
        wrappedPokemon.setSPCStage(SPCStage);
    }

    public void setACCStage(int ACCStage) {
        wrappedPokemon.setACCStage(ACCStage);
    }

    public void setEVAStage(int EVAStage) {
        wrappedPokemon.setEVAStage(EVAStage);
    }

    public EleType getType1() {
        return wrappedPokemon.getType1();
    }

    public EleType getType2() {
        return wrappedPokemon.getType2();
    }

    public void loseHP(int HPLoss) {
        wrappedPokemon.loseHP(HPLoss);
    }

    public void loseHP(int HPLoss, Move move){
        wrappedPokemon.loseHP(HPLoss, move);
    }

    public void gainHP(int HPGain) {
        wrappedPokemon.gainHP(HPGain);
    }

    public boolean hasFainted() {
        return wrappedPokemon.hasFainted();
    }

    public void changeATK(int stage) {
        wrappedPokemon.changeATK(stage);
    }

    public void changeSPD(int stage) {
        wrappedPokemon.changeSPD(stage);
    }

    public void changeDEF(int stage) {
        wrappedPokemon.changeDEF(stage);
    }

    public void changeSPC(int stage) {
        wrappedPokemon.changeSPC(stage);
    }

    public void changeACC(int stage) {
        wrappedPokemon.changeACC(stage);
    }

    public void changeEVA(int stage) {
        wrappedPokemon.changeEVA(stage);
    }

    public int getPokedexNo() {
        return wrappedPokemon.getPokedexNo();
    }

    public int getBaseHP() {
        return wrappedPokemon.getBaseHP();
    }

    public int getBaseATK() {
        return wrappedPokemon.getBaseATK();
    }

    public int getBaseDEF(AttackState move) {
        return wrappedPokemon.getBaseDEF(move);
    }

    public int getBaseSPC(AttackState move) {
        return wrappedPokemon.getBaseSPC(move);
    }

    public int getBaseSPD() {
        return wrappedPokemon.getBaseSPD();
    }

    public int getCurHP() {
        return wrappedPokemon.getCurHP();
    }

    public int getCurATK() {
        return wrappedPokemon.getCurATK();
    }

    public int getCurDEF(AttackState move) {
        return wrappedPokemon.getCurDEF(move);
    }

    public int getCurSPC(AttackState move) {
        return wrappedPokemon.getCurSPC(move);
    }

    public int getCurSPD() {
        return wrappedPokemon.getCurSPD();
    }

    public int getCurACC() {
        return wrappedPokemon.getCurACC();
    }

    public int getCurEVA() {
        return wrappedPokemon.getCurEVA();
    }

    public boolean isType(EleType type) {
        return wrappedPokemon.isType(type);
    }

    public void setType1(EleType type1) {
        wrappedPokemon.setType1(type1);
    }

    public void setType2(EleType type2) {
        wrappedPokemon.setType2(type2);
    }

    public void selectMove() {
        wrappedPokemon.selectMove();
    }

    public void selectMove(int moveIndex) {
        wrappedPokemon.selectMove(moveIndex);
    }

    public void selectMove(Class<?> moveClass) {
        wrappedPokemon.selectMove(moveClass);
    }

    public void attack(Pokemon toAttack) {
        wrappedPokemon.attack(toAttack);
    }

    public String getName() {
        return wrappedPokemon.getName();
    }

    public void runPreBattleStates() {
        wrappedPokemon.runPreBattleStates();
    }

    public void runPostBattleStates() {
        wrappedPokemon.runPostBattleStates();
    }


    public AttackState getAttackState() {
        return wrappedPokemon.getAttackState();
    }

    public void setAttackState(AttackState attackState) {
        wrappedPokemon.setAttackState(attackState);
    }

    public void addPostBattleState(BattleState battleState) {
        wrappedPokemon.addPostBattleState(battleState);
    }

    public void setShouldSelectMove(boolean shouldSelectMove) {
        wrappedPokemon.setShouldSelectMove(shouldSelectMove);
    }

    public List<BattleState> getPreBattleStates() {
        return wrappedPokemon.getPreBattleStates();
    }

    public List<BattleState> getPostBattleStates() {
        return wrappedPokemon.getPostBattleStates();
    }

    public List<Move> getMoves() {
        return wrappedPokemon.getMoves();
    }

    public void setMoves(List<Move> moves) {
        wrappedPokemon.setMoves(moves);
    }

    public int getATK() {
        return wrappedPokemon.getATK();
    }

    public int getSPD() {
        return wrappedPokemon.getSPD();
    }

    public int getDEF(AttackState move) {
        return wrappedPokemon.getDEF(move);
    }

    public int getSPC() {
        return wrappedPokemon.getSPC();
    }

    public void setATK(int ATK) {
        wrappedPokemon.setATK(ATK);
    }

    public void setSPD(int SPD) {
        wrappedPokemon.setSPD(SPD);
    }

    public void setDEF(int DEF) {
        wrappedPokemon.setDEF(DEF);
    }

    public void setSPC(int SPC) {
        wrappedPokemon.setSPC(SPC);
    }

    public void setAttackState(Class<?> attackStateClass) {
        wrappedPokemon.setAttackState(attackStateClass);
    }

    public double getCritBonus() {
        return wrappedPokemon.getCritBonus();
    }

    public void setCritBonus(int bonus) {
        wrappedPokemon.setCritBonus(bonus);
    }
}
