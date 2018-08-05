package BattleField;

import Facade.FacadeFactory;
import Pokemons.Pokedex;
import Pokemons.Pokemon;

public class BattleField {
    private static void endl(){
        FacadeFactory.getInstance(IBattleLogger.class).println();
    }

    public static void main(String[] args){
        Pokemon pokemon1 = Pokedex.getPokemon("Magmar");//magmar
        Pokemon pokemon2 = Pokedex.getPokemon(41);//zubat
        int turns = 100;
        runBattle(pokemon1, pokemon2, turns);
    }

    public static void runBattle(Pokemon pokemon1, Pokemon pokemon2, int num_of_turns) {
        for (int i = 0; i < num_of_turns; i++) {
            pokemon1.selectMove();
            pokemon2.selectMove();
            endl();

            pokemon1.runPreBattleStates();
            pokemon2.runPreBattleStates();
            if (speedCompare(pokemon1, pokemon2)){
                pokemon1.attack(pokemon2);
                pokemon2.attack(pokemon1);
            }
            else {
                pokemon1.attack(pokemon2);
                pokemon2.attack(pokemon1);
            }
            pokemon1.runPostBattleStates();
            pokemon2.runPostBattleStates();

            endl();
        }
    }

    private static boolean speedCompare(Pokemon pokemon1, Pokemon pokemon2){
        if (pokemon1.getAttackState().getSpeedPriority() != pokemon2.getAttackState().getSpeedPriority())
            return pokemon1.getAttackState().getSpeedPriority() > pokemon2.getAttackState().getSpeedPriority();
        return pokemon1.getCurSPD() > pokemon2.getCurSPD();
    }
}
