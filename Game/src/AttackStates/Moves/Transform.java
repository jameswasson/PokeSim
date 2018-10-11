package AttackStates.Moves;

import AttackStates.Move;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.Pokemon;
import Pokemons.TransformedPokemon;

//If a transformed pokemon receives a critical hit, it's original stats are used, this requires a wrapper.
public class Transform extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.setBasePokemon(new TransformedPokemon(ourselves,opponent));
        IBattleLogger log = FacadeFactory.getInstance(IBattleLogger.class);
        log.println(ourselves.getName() + " Transformed into " + opponent.getName() + "!");
    }
}
