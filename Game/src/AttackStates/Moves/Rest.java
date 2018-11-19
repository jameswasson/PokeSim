package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Asleep;
import Pokemons.Pokemon;

public class Rest extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Asleep.tryToPutToSleep(ourselves, 2);
        ourselves.gainHP(ourselves.getBaseHP() - ourselves.getCurHP());
        logger.println(ourselves.getName() + " regained health!");
    }
}
