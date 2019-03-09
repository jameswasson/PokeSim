package pokemons;


import attack_states.AttackState;
import attack_states.Move;

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
    private TransformedPokemon(Pokemon ourselves, Pokemon opponent) {
        wrappedPokemon = ourselves.getBasePokemon();

        //copies moves
        List<Move> ourNewMoves = new ArrayList<>();
        for (Move move : opponent.getMoves()) {
            Move newMove = Move.getMove(Move.getName(move.getClass()));
            int pp = newMove.getPowerPoints();
            newMove.setCurrentPowerPoints(Math.min(5, pp));
            ourNewMoves.add(newMove);
        }
        wrappedPokemon.setMoves(ourNewMoves);

        //copies type
        wrappedPokemon.setType1(opponent.getType1());
        wrappedPokemon.setType2(opponent.getType2());

        //copies stats
        wrappedPokemon.setATK(opponent.getBaseATK());
        wrappedPokemon.setSPD(opponent.getBaseSPD());
        opponentBaseSPC = opponent.getBaseSPC(null);
        opponentBaseDEF = opponent.getBaseDEF(null);
    }

    public static void transform(Pokemon ourselves, Pokemon opponent) {
        ourselves.setWrappedPokemon(new TransformedPokemon(ourselves, opponent));
    }

    @Override
    public int getBaseSPC(AttackState move) {
        if (move == null)
            return opponentBaseSPC;
        else if (move.wasCritical())
            return wrappedPokemon.getBaseSPC(null);
        else
            return opponentBaseSPC;
    }

    @Override
    public int getBaseDEF(AttackState move) {
        if (move == null)
            return opponentBaseDEF;
        else if (move.wasCritical())
            return wrappedPokemon.getBaseDEF(null);
        else
            return opponentBaseDEF;
    }
}
