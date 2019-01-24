package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;

public class MegaDrain extends Move {
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        dealDamage(ourselves, opponent, damage);
        int healAmount = Math.max(damage / 2, 1);
        ourselves.gainHP(healAmount);
        logger.println(ourselves.getName() + " gained HP from " + opponent.getName());
    }
}
