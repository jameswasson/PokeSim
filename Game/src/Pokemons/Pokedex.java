package Pokemons;

import Utils.PokedexParser;

import java.util.HashMap;
import java.util.Map;

public class Pokedex {
    private static Pokedex myPokedex;
    private static Pokedex getPokedex(){
        if (myPokedex == null) {
            myPokedex = new Pokedex();
            PokedexParser.loadPokedex();
        }
        return myPokedex;
    }
    private Map<Integer, Pokemon> dex;
    private Pokedex(){
        dex = new HashMap<>();
    }

    public static Pokemon getPokemon(int pokedexNo){
        return getPokedex()._getPokemon(pokedexNo);
    }
    public Pokemon _getPokemon(int pokedexNo){
        return Pokemon.copyPokemon(dex.get(pokedexNo));
    }
    public static void loadDex(Pokemon pokemon){
        getPokedex()._loadDex(pokemon);
    }
    private void _loadDex(Pokemon pokemon){
        dex.put(pokemon.getPokedexNo(), pokemon);
    }
}
