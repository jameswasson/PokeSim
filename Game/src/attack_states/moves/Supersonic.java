package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Confused;
import pokemons.Pokemon;

public class Supersonic extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Confused.tryToConfuse(opponent);
    }
}
