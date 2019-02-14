package attack_states.moves;

import attack_states.Move;
import pokemons.EleType;
import pokemons.Pokedex;
import pokemons.Pokemon;

public class NightShade extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, opponent.getLevel());
    }

    @Override
    protected boolean noEffect(EleType type1, EleType type2) {
        return false;
    }
}
