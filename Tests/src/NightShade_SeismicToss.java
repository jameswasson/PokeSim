import attack_states.moves.NightShade;
import attack_states.moves.SeismicToss;
import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;

public class NightShade_SeismicToss extends MoveTest {
    @Test
    public void canHitNightShade() {
        Pokemon Gengar = Pokedex.getPokemon("Gengar");
        Pokemon Lickitung = Pokedex.getPokemon("Lickitung");
        Gengar.selectMove(NightShade.class);
        Gengar.attack(Lickitung);
        assert (Lickitung.getBaseHP() != Lickitung.getCurHP());
        assert (attack_states.Move.getName(NightShade.class).equals("Night Shade"));
    }

    @Test
    public void canHitSeismicToss() {
        Pokemon Gengar = Pokedex.getPokemon("Gengar");
        Pokemon Lickitung = Pokedex.getPokemon("Lickitung");
        Lickitung.selectMove(SeismicToss.class);
        Lickitung.attack(Gengar);
        assert (Gengar.getBaseHP() != Gengar.getCurHP());
        assert (attack_states.Move.getName(SeismicToss.class).equals("Seismic Toss"));
    }
}
