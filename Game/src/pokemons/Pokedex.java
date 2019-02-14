package pokemons;


import utils.PokedexParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokedex {
    private static Map<String, List<String>> dexName;

    public static Pokemon getPokemon(String name) {
        if (dexName == null){
            dexName = new HashMap<>();
            PokedexParser.loadPokedex();
        }
        return new WrapperPokemon(new BasePokemon(name));
    }

    static List<String> getPokemonInfo(String name) {
        return dexName.get(name);
    }

    public static void addPokemon(String name, List<String> info) {
        dexName.put(name, info);
    }
}
