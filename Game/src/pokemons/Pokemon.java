package pokemons;


import attack_states.AttackState;
import attack_states.Move;
import battle_field.IBattleLogger;
import battle_states.BattleState;
import facade.FacadeFactory;

import java.util.List;

public abstract class Pokemon {
    public static final IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);

    public Pokemon() {
    }

    public abstract boolean containsState(Class<? extends WrapperPokemon> klass);

    public abstract Pokemon getHead();

    public abstract void setHead(Pokemon head);

    public abstract int getLevel();

    public abstract String getName();

    public abstract EleType getType1();

    public abstract void setType1(EleType type1);

    public abstract EleType getType2();

    public abstract void setType2(EleType type2);

    public abstract BasePokemon getBasePokemon();

    public abstract Pokemon getWrappedPokemon();

    public abstract void setWrappedPokemon(Pokemon pokemon);

    public abstract boolean isType(EleType type);

    public abstract void selectMove();

    public abstract void selectMove(int moveIndex);

    public abstract void selectMove(Class<? extends Move> moveClass);

    public abstract void selectMove(Move move);

    public abstract void attack(Pokemon toAttack);

    public abstract void runPostBattleStates();

    public abstract Move getSelectedMove();

    public abstract void addPostBattleState(BattleState battleState);

    public abstract void setShouldSelectMove(boolean shouldSelectMove);

    public abstract List<BattleState> getPostBattleStates();

    public abstract List<Move> getMoves();

    public abstract void setMoves(List<Move> moves);

    public abstract boolean hasFainted();

    public abstract double getCritBonus();

    public abstract void setCritBonus(int bonus);

    public abstract int getATK();

    public abstract void setATK(int ATK);

    public abstract int getSPD();

    public abstract void setSPD(int SPD);

    public abstract int getDEF(AttackState move);

    public abstract int getSPC();

    public abstract void setSPC(int SPC);

    public abstract void loseHP(int HPLoss);

    public abstract void loseHP(int HPLoss, Move move);

    public abstract void gainHP(int HPGain);

    public abstract void setDEF(int DEF);

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
