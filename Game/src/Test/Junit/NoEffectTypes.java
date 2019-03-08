package Junit;

import org.junit.Test;
import pokemons.Pokedex;
import pokemons.Pokemon;

import static org.junit.Assert.assertEquals;

public class NoEffectTypes extends Move {
    @Test
    public void ghostMove(){
        Pokemon Gengar = Pokedex.getPokemon("Gengar");
        Magikarp.selectMove(1);
        Magikarp.attack(Gengar);
        assertEquals(Gengar.getCurHP(), Gengar.getBaseHP());
    }
}
