package AttackStates.Moves;

import AttackStates.Move;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

public class Conversion extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.setType1(opponent.getType1());
        ourselves.setType2(opponent.getType2());
        logger.println(ourselves.getName() + " transformed into the " + ourselves.getType1().name().toUpperCase() + " type!");
    }
}
