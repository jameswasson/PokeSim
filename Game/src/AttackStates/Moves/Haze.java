package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class Haze extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent) {
        removeStatusCondition(ourselves);
        removeStatusCondition(opponent);
    }
    public static void removeStatusCondition(Pokemon pokemon){
        pokemon.setACCStage(0);
        pokemon.setATKStage(0);
        pokemon.setDEFStage(0);
        pokemon.setSPDStage(0);
        pokemon.setSPCStage(0);
        pokemon.setEVAStage(0);
        /*todo remove the following
          paraylsis
          burn
          Focus energy
          dire hit
          mist
          guard spec
          xaccuracy
          leech seed
          disable
          reflect
          light screen
          confusion
          turn bad Poison to regular poison
          freeze
          sleep
         */
    }
}
