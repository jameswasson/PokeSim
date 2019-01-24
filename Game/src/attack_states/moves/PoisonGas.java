package attack_states.moves;

import attack_states.Move;
import battle_states.post.Poison;
import pokemons.Pokemon;

public class PoisonGas extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Poison.tryToPoison(opponent);
    }
}
