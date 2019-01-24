package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Agility extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.changeSPD(2);
    }
}
