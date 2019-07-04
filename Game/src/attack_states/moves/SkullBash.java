package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class SkullBash extends Move {
    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        if (!ourselves.containsState(ChargingSkullBashPokemon.class)) {
            sayWeUsedMove(ourselves);
            logger.println(ourselves.getName() + " lowered its head!");
            WrapperPokemon.wrap(ourselves, new ChargingSkullBashPokemon());
            ourselves.setShouldSelectMove(false);
        }
        else
            super.execute(ourselves, opponent);
    }

    public class ChargingSkullBashPokemon extends WrapperPokemon
    {
        @Override
        public void attack(Pokemon toAttack) {
            super.attack(toAttack);
            removeSelf();
            setShouldSelectMove(true);
        }
    }
}
