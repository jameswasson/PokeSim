package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Paralyzed;
import pokemons.Pokemon;
import utils.RNG;

public class BodySlam extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            Paralyzed.tryToParalyze(opponent);
    }
}