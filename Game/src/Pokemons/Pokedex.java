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
    private Map<Integer, Pokemon> dexNo;
    private Map<String, Pokemon> dexName;
    private Pokedex(){
        dexNo = new HashMap<>();
        dexName = new HashMap<>();
    }


    public static Pokemon getPokemon(String name){
        return getPokedex()._getPokemon(name);
    }
    private Pokemon _getPokemon(String name){
        return WrapperPokemon.copyPokemon(dexName.get(name));
    }
    public static Pokemon getPokemon(int pokedexNo){
        return getPokedex()._getPokemon(pokedexNo);
    }
    private Pokemon _getPokemon(int pokedexNo){
        return WrapperPokemon.copyPokemon(dexNo.get(pokedexNo));
    }
    public static void loadDex(Pokemon pokemon){
        getPokedex()._loadDex(pokemon);
    }
    private void _loadDex(Pokemon pokemon){
        dexNo.put(pokemon.getPokedexNo(), pokemon);
        dexName.put((pokemon.getName()), pokemon);
    }
}
