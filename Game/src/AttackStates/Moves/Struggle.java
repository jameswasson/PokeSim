package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Struggle extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        ourselves.loseHP(Math.max(1, damage / 2));
        logger.println(ourselves.getName() + " is hit with recoil!");
    }
}
