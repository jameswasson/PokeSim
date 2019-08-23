import attack_states.Move;
import attack_states.moves.NightShade;
import attack_states.moves.SeismicToss;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NightShade_SeismicToss extends MoveTest {
    @Test
    public void canHitNightShade() {
        Pokemon Lickitung = Pokedex.getPokemon("Lickitung");
        assertFalse(new NightShade().noEffect(Lickitung));
    }

    @Test
    public void canHitSeismicToss() {
        Pokemon Lickitung = Pokedex.getPokemon("Lickitung");
        assertFalse(new SeismicToss().noEffect(Lickitung));
    }
}
