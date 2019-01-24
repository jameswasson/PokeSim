package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Paralyzed;
import pokemons.Pokemon;

public class StunSpore extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Paralyzed.tryToParalyze(opponent);
    }
}
