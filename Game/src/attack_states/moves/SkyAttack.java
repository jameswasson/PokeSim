package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;
import pokemons.pokemon_states.FlinchedPokemon;
import utils.RNG;

public class SkyAttack extends Move {
    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        if (!ourselves.containsState(ChargingSkyAttackPokemon.class)) {
            sayWeUsedMove(ourselves);
            logger.println(ourselves.getName() + " is glowing!");
            WrapperPokemon.wrap(ourselves, new ChargingSkyAttackPokemon());
            ourselves.setShouldSelectMove(false);
        } else
            super.execute(ourselves, opponent);
    }

    public class ChargingSkyAttackPokemon extends WrapperPokemon {
        @Override
        public void attack(Pokemon toAttack) {
            super.attack(toAttack);
            removeSelf();
            setShouldSelectMove(true);
        }
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (RNG.random() < .3)
            FlinchedPokemon.makeFlinch(opponent);
    }
}
