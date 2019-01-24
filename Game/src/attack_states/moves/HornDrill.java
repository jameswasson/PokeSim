package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class HornDrill extends Move {
    @Override
    protected double getAccuracy(Pokemon ourselves, Pokemon opponent) {
        return new Guillotine().getAccuracy(ourselves, opponent);
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        new Guillotine().attack(ourselves, opponent, damage);
    }
}
