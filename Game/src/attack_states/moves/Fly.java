package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class Fly extends Move {

    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        if (!isFlying(ourselves)) {
            sayWeUsedMove(ourselves);
            logger.println(ourselves.getName() + " flew up high!");
            WrapperPokemon.wrap(ourselves, new FlyingPokemon());
            ourselves.setShouldSelectMove(false);
        }
        else
            super.execute(ourselves, opponent);
    }

    public class FlyingPokemon extends WrapperPokemon {
        @Override
        public void attack(Pokemon toAttack) {
            super.attack(toAttack);
            removeSelf();
            setShouldSelectMove(true);
        }
    }

    public static boolean isFlying(Pokemon pokemon){
        return pokemon.containsState(FlyingPokemon.class);
    }
}
