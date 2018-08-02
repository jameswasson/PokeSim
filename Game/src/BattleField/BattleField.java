package BattleField;

import Facade.FacadeFactory;
import Pokemons.IPokemon;
import Pokemons.Pokedex;
import Pokemons.Pokemon;

public class BattleField {
    private static void endl(){
        FacadeFactory.getInstance(IBattleLogger.class).println();
    }

    public static void main(String[] args){
        IPokemon pokemon1 = Pokedex.getPokemon(126);//magmar
        IPokemon pokemon2 = Pokedex.getPokemon(41);//zubat
        int turns = 100;
        runBattle(pokemon1, pokemon2, turns);
    }

    public static void runBattle(IPokemon pokemon1, IPokemon pokemon2, int num_of_turns) {
        for (int i = 0; i < num_of_turns; i++) {
            pokemon1.selectMove();
            pokemon2.selectMove();
            endl();

            pokemon1.runPreBattleStates();
            pokemon2.runPreBattleStates();
            pokemon1.attack(pokemon2);
            pokemon2.attack(pokemon1);
            pokemon1.runPostBattleStates();
            pokemon2.runPostBattleStates();

            endl();
        }
    }
}
