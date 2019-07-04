package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class SolarBeam extends Move {
    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        if (!ourselves.containsState(ChargingSolarBeamPokemon.class)) {
            sayWeUsedMove(ourselves);
            logger.println(ourselves.getName() + " took in sunlight!");
            WrapperPokemon.wrap(ourselves, new ChargingSolarBeamPokemon());
            ourselves.setShouldSelectMove(false);
        }
        else
            super.execute(ourselves, opponent);
    }

    public class ChargingSolarBeamPokemon extends WrapperPokemon
    {
        @Override
        public void attack(Pokemon toAttack) {
            super.attack(toAttack);
            removeSelf();
            setShouldSelectMove(true);
        }
    }
}
