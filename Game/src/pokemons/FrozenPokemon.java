package pokemons;


import attack_states.Move;
import attack_states.moves.FireBlast;
import attack_states.moves.FirePunch;
import attack_states.moves.Flamethrower;
import battle_states.pre.Frozen;

public class FrozenPokemon extends WrapperPokemon {

    @Override
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
