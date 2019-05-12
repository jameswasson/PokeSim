package attack_states.moves;

import attack_states.Move;
import pokemons.EleType;
import pokemons.pokemon_states.ParalyzedPokemon;
import pokemons.Pokemon;

public class Thunder extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (opponent.getType1() != EleType.ELECTRIC && opponent.getType2() != EleType.ELECTRIC) {
            ParalyzedPokemon.tryToParalyze(opponent);
        }
    }
}
