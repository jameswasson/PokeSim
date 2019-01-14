package Pokemons;

import AttackStates.AttackState;
import AttackStates.Move;
import BattleStates.BattleState;

import java.util.List;

public abstract class Pokemon {
    public Pokemon() {
    }

    public abstract int getLevel();

    public abstract String getName();

    public abstract int getPokedexNo();

    public abstract EleType getType1();

    public abstract EleType getType2();

    public abstract BasePokemon getBasePokemon();

    public abstract void setBasePokemon(Pokemon pokemon);

    public abstract boolean isType(EleType type);

    public abstract void setType1(EleType type1);

    public abstract void setType2(EleType type2);

    public abstract void selectMove();

    public abstract void selectMove(int moveIndex);

    public abstract void selectMove(Class<?> moveClass);

    public abstract void attack(Pokemon toAttack);

    public abstract void runPreBattleStates();

    public abstract void runPreBattleStates(Pokemon pokemon);

    public abstract void runPostBattleStates();

    public abstract void runPostBattleStates(Pokemon pokemon);

    public abstract AttackState getAttackState();

    public abstract void setAttackState(AttackState attackState);

    public abstract void addPostBattleState(BattleState battleState);

    public abstract void setShouldSelectMove(boolean shouldSelectMove);

    public abstract List<BattleState> getPreBattleStates();

    public abstract List<BattleState> getPostBattleStates();

    public abstract List<Move> getMoves();

    public abstract void setMoves(List<Move> moves);

    public abstract void setAttackState(Class<?> attackStateClass);

    public abstract boolean hasFainted();

    public abstract double getCritBonus();

    public abstract void setCritBonus(int bonus);

    public abstract int getATK();

    public abstract int getSPD();

    public abstract int getDEF(AttackState move);

    public abstract int getSPC();

    public abstract void loseHP(int HPLoss);

    public abstract void gainHP(int HPGain);

    public abstract void setATK(int ATK);

    public abstract void setSPD(int SPD);

    public abstract void setDEF(int DEF);

    public abstract void setSPC(int SPC);

    public abstract int getBaseHP();

    public abstract int getBaseATK();

    public abstract int getBaseDEF(AttackState move);

    public abstract int getBaseSPC(AttackState move);

    public abstract int getBaseSPD();

    public abstract int getCurHP();

    public abstract int getCurATK();

    public abstract int getCurDEF(AttackState move);

    public abstract int getCurSPC(AttackState move);

    public abstract int getCurSPD();

    public abstract int getCurACC();

    public abstract int getCurEVA();

    public abstract void setATKStage(int ATKStage);

    public abstract void setSPDStage(int SPDStage);

    public abstract void setDEFStage(int DEFStage);

    public abstract void setSPCStage(int SPCStage);

    public abstract void setACCStage(int ACCStage);

    public abstract void setEVAStage(int EVAStage);

    public abstract void changeATK(int stage);

    public abstract void changeSPD(int stage);

    public abstract void changeDEF(int stage);

    public abstract void changeSPC(int stage);

    public abstract void changeACC(int stage);

    public abstract void changeEVA(int stage);
}
