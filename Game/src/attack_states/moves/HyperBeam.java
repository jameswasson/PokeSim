package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import pokemons.WrapperPokemon;

public class HyperBeam extends Move {
    //todo let HyperBeam penetrate Substitutes.
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        WrapperPokemon.wrap(ourselves, new BeamChargingPokemon());
        logger.println(ourselves.getName() + " must recharge!");
        ourselves.setShouldSelectMove(false);
    }

    public class BeamChargingPokemon extends WrapperPokemon {
        @Override
        public void attack(Pokemon toAttack) {
            logger.println(getName() + " is recharging!");
            setShouldSelectMove(true);
            removeSelf();
        }
    }
}
