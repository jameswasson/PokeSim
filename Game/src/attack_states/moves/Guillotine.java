package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class Guillotine extends Move {
    @Override
    protected double getAccuracy(Pokemon ourselves, Pokemon opponent) {
        if (ourselves.getLevel() < opponent.getLevel() || ourselves.getCurSPD() < opponent.getCurSPD())
            return 0;
        else
            return (double) (ourselves.getLevel() - opponent.getLevel() + 30);
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        //deal enough damage to knockout opponent
        super.attack(ourselves, opponent, opponent.getBaseHP());
    }
}
