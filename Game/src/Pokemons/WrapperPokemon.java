package Pokemons;

import AttackStates.AttackState;
import AttackStates.Move;
import BattleStates.BattleState;

import java.util.List;

public class WrapperPokemon extends Pokemon {

    Pokemon basePokemon;

    public void setBasePokemon(Pokemon pokemon) {
        this.basePokemon = pokemon;
    }

    public BasePokemon getBasePokemon() {
        return basePokemon.getBasePokemon();
    }

    public WrapperPokemon() {
    }

    public WrapperPokemon(BasePokemon pokemon) {
        basePokemon = pokemon;
    }

    public int getLevel() {
        return basePokemon.getLevel();
    }

    public void setATKStage(int ATKStage) {
        basePokemon.setATKStage(ATKStage);
    }

    public void setSPDStage(int SPDStage) {
        basePokemon.setSPDStage(SPDStage);
    }

    public void setDEFStage(int DEFStage) {
        basePokemon.setDEFStage(DEFStage);
    }

    public void setSPCStage(int SPCStage) {
        basePokemon.setSPCStage(SPCStage);
    }

    public void setACCStage(int ACCStage) {
        basePokemon.setACCStage(ACCStage);
    }

    public void setEVAStage(int EVAStage) {
        basePokemon.setEVAStage(EVAStage);
    }

    public EleType getType1() {
        return basePokemon.getType1();
    }

    public EleType getType2() {
        return basePokemon.getType2();
    }

    public void loseHP(int HPLoss) {
        basePokemon.loseHP(HPLoss);
    }

    public void gainHP(int HPGain) {
        basePokemon.gainHP(HPGain);
    }

    public boolean hasFainted() {
        return basePokemon.hasFainted();
    }

    public void changeATK(int stage) {
        basePokemon.changeATK(stage);
    }

    public void changeSPD(int stage) {
        basePokemon.changeSPD(stage);
    }

    public void changeDEF(int stage) {
        basePokemon.changeDEF(stage);
    }

    public void changeSPC(int stage) {
        basePokemon.changeSPC(stage);
    }

    public void changeACC(int stage) {
        basePokemon.changeACC(stage);
    }

    public void changeEVA(int stage) {
        basePokemon.changeEVA(stage);
    }

    public int getPokedexNo() {
        return basePokemon.getPokedexNo();
    }

    public int getBaseHP() {
        return basePokemon.getBaseHP();
    }

    public int getBaseATK() {
        return basePokemon.getBaseATK();
    }

    public int getBaseDEF(AttackState move) {
        return basePokemon.getBaseDEF(move);
    }

    public int getBaseSPC(AttackState move) {
        return basePokemon.getBaseSPC(move);
    }

    public int getBaseSPD() {
        return basePokemon.getBaseSPD();
    }

    public int getCurHP() {
        return basePokemon.getCurHP();
    }

    public int getCurATK() {
        return basePokemon.getCurATK();
    }

    public int getCurDEF(AttackState move) {
        return basePokemon.getCurDEF(move);
    }

    public int getCurSPC(AttackState move) {
        return basePokemon.getCurSPC(move);
    }

    public int getCurSPD() {
        return basePokemon.getCurSPD();
    }

    public int getCurACC() {
        return basePokemon.getCurACC();
    }

    public int getCurEVA() {
        return basePokemon.getCurEVA();
    }

    public boolean isType(EleType type) {
        return basePokemon.isType(type);
    }

    public void setType1(EleType type1) {
        basePokemon.setType1(type1);
    }

    public void setType2(EleType type2) {
        basePokemon.setType2(type2);
    }

    public void selectMove() {
        basePokemon.selectMove();
    }

    public void selectMove(int moveIndex) {
        basePokemon.selectMove(moveIndex);
    }

    public void selectMove(Class<?> moveClass) {
        basePokemon.selectMove(moveClass);
    }

    public void attack(Pokemon toAttack) {
        basePokemon.attack(toAttack);
    }

    public String getName() {
        return basePokemon.getName();
    }

    public void runPreBattleStates() {
        basePokemon.runPreBattleStates(this);
    }

    public void runPreBattleStates(Pokemon pokemon) {
        basePokemon.runPreBattleStates(pokemon);
    }

    public void runPostBattleStates() {
        basePokemon.runPostBattleStates(this);
    }

    public void runPostBattleStates(Pokemon pokemon) {
        basePokemon.runPostBattleStates(pokemon);
    }

    public AttackState getAttackState() {
        return basePokemon.getAttackState();
    }

    public void setAttackState(AttackState attackState) {
        basePokemon.setAttackState(attackState);
    }

    public void addPostBattleState(BattleState battleState) {
        basePokemon.addPostBattleState(battleState);
    }

    public void setShouldSelectMove(boolean shouldSelectMove) {
        basePokemon.setShouldSelectMove(shouldSelectMove);
    }

    public List<BattleState> getPreBattleStates() {
        return basePokemon.getPreBattleStates();
    }

    public List<BattleState> getPostBattleStates() {
        return basePokemon.getPostBattleStates();
    }

    public List<Move> getMoves() {
        return basePokemon.getMoves();
    }

    public void setMoves(List<Move> moves) {
        basePokemon.setMoves(moves);
    }

    public int getATK() {
        return basePokemon.getATK();
    }

    public int getSPD() {
        return basePokemon.getSPD();
    }

    public int getDEF(AttackState move) {
        return basePokemon.getDEF(move);
    }

    public int getSPC() {
        return basePokemon.getSPC();
    }

    public void setATK(int ATK) {
        basePokemon.setATK(ATK);
    }

    public void setSPD(int SPD) {
        basePokemon.setSPD(SPD);
    }

    public void setDEF(int DEF) {
        basePokemon.setDEF(DEF);
    }

    public void setSPC(int SPC) {
        basePokemon.setSPC(SPC);
    }

    public void setAttackState(Class<?> attackStateClass) {
        basePokemon.setAttackState(attackStateClass);
    }

    public double getCritBonus() {
        return basePokemon.getCritBonus();
    }

    public void setCritBonus(int bonus) {
        basePokemon.setCritBonus(bonus);
    }
}
