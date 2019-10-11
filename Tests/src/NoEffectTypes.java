import org.junit.jupiter.api.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoEffectTypes extends MoveTest {
    @Test
    public void ghostMove() {
        Pokemon Gengar = Pokedex.getPokemon("Gengar");
        Magikarp.selectMove(1);
        MoveTest.customMoveMiss(Magikarp.getSelectedMove(), false);
        Magikarp.attack(Gengar);
        assertEquals(Gengar.getCurHP(), Gengar.getBaseHP());
    }
}
