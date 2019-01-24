package attack_states.moves;

import attack_states.Move;
import battle_states.post.BadPoison;
import pokemons.Pokemon;

public class Toxic extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        BadPoison.tryToBadlyPoison(opponent);
    }
}
