package Pokemons;

import Utils.PokedexParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokedex {
    private Map<String, List<String>> dexName;
    private static Pokedex pokedex;

    private Pokedex() {
        dexName = new HashMap<>();
    }

    private static Pokedex getPokedex() {
        if (pokedex == null) {
            pokedex = new Pokedex();
            PokedexParser.loadPokedex();
        }
        return pokedex;
    }

    private List<String> _getPokemonInfo(String name) {
        return dexName.get(name);
    }

    public static List<String> getPokemonInfo(String name) {
        return getPokedex()._getPokemonInfo(name);
    }

    private void _addPokemon(String name, List<String> info) {
        dexName.put(name, info);
    }

    public static void addPokemon(String name, List<String> info) {
        getPokedex()._addPokemon(name, info);
    }

    public static Pokemon getPokemon(String name) {
        return new WrapperPokemon(new BasePokemon(name));
    }
}
