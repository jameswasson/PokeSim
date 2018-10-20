package AttackStates.Moves;

import AttackStates.Move;
import BattleField.IBattleLogger;
import Pokemons.Pokemon;

public class DoubleEdge extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        int damgeToLose = Math.max(damage / 4, 1);
        ourselves.loseHP(damgeToLose);
        logger.println(ourselves.getName() + " is hit with recoil!");
    }
}
