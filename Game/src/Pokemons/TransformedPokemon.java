package Pokemons;

import AttackStates.AttackState;
import AttackStates.Move;

import java.util.ArrayList;
import java.util.List;

public class TransformedPokemon extends WrapperPokemon {
    private int opponentBaseSPC;
    private int opponentBaseDEF;

    /*
     * Things to note:
     * Pokemon cannot transform back to original form, so let's write over unimportant data
     * ourselves.def and ourselves.spc are important data
     * opponent.def and opponent.spc must be stored somehow
     * we should not store opponent anywhere in the case opponent changes (transform, substitue, light screen, etc)
     * */
    public TransformedPokemon(Pokemon ourselves, Pokemon opponent) {
        basePokemon = ourselves.getBasePokemon();

        //copies moves
        List<Move> opponentMoves = opponent.getMoves();
        List<Move> ourNewMoves = new ArrayList<>();
        for (Move move : opponentMoves) {
            Move newMove = Move.copyMove(move);
            int pp = newMove.getPowerPoints();
            newMove.setCurrentPowerPoints(Math.min(5, pp));
            ourNewMoves.add(Move.copyMove(newMove));
        }
        basePokemon.setMoves(ourNewMoves);

        //copies type
        EleType type1;
        EleType type2;
        type1 = opponent.getType1();
        type2 = opponent.getType2();
        basePokemon.setType1(type1);
        basePokemon.setType2(type2);

        //copies stats
        basePokemon.setATK(opponent.getBaseATK());
        basePokemon.setSPD(opponent.getBaseSPD());
        opponentBaseSPC = opponent.getBaseSPC(null);
        opponentBaseDEF = opponent.getBaseDEF(null);
    }

    @Override
    public int getBaseSPC(AttackState move) {
        if (move == null)
            return opponentBaseSPC;
        else if (move.wasCritical())
            return basePokemon.getBaseSPC(null);
        else
            return opponentBaseSPC;
    }

    @Override
    public int getBaseDEF(AttackState move) {
        if (move == null)
            return opponentBaseDEF;
        else if (move.wasCritical())
            return basePokemon.getBaseDEF(null);
        else
            return opponentBaseDEF;
    }
}
