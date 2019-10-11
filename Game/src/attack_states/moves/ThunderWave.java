package attack_states.moves;

import attack_states.Move;
import pokemons.EleType;
import pokemons.Pokemon;
import pokemons.pokemon_states.ParalyzedPokemon;

public class ThunderWave extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        if (opponent.getType1() != EleType.GROUND && opponent.getType2() != EleType.GROUND) {
            ParalyzedPokemon.tryToParalyze(opponent);
        }
    }
}
