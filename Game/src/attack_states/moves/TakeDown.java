package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class TakeDown extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        ourselves.loseHP(Math.max(1, damage / 4));
        logger.println(ourselves.getName() + " is hit with recoil!");
    }
}
