package Pokemons;

import AttackStates.Move;
import AttackStates.Moves.FireBlast;
import AttackStates.Moves.FirePunch;
import AttackStates.Moves.Flamethrower;
import BattleStates.pre.Frozen;

public class FrozenPokemon extends WrapperPokemon {

    public void loseHP(int HPLoss, Move move) {
        boolean canBurn = move instanceof FireBlast ||
                move instanceof FirePunch ||
                move instanceof Flamethrower;
        if (canBurn) {
            Frozen.removeFreeze(getHead());
            removeSelf();
        }
        super.loseHP(HPLoss);
    }
}
