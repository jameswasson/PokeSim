package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class Dig extends Move {
    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        if (!isDigging(ourselves)) {
            sayWeUsedMove(ourselves);
            logger.println(ourselves.getName() + " burrowed its way under the ground!");
            WrapperPokemon.wrap(ourselves, new DiggingPokemon());
            ourselves.setShouldSelectMove(false);
        } else
            super.execute(ourselves, opponent);
    }

    public class DiggingPokemon extends WrapperPokemon {
        @Override
        public void attack(Pokemon toAttack) {
            super.attack(toAttack);
            removeSelf();
            setShouldSelectMove(true);
        }
    }

    public static boolean isDigging(Pokemon pokemon) {
        return pokemon.containsState(DiggingPokemon.class);
    }
}
