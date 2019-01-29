package battle_field;

import facade.FacadeFactory;
import pokemons.Pokedex;
import pokemons.Pokemon;

public class BattleField {
    private static void endl() {
        FacadeFactory.getInstance(IBattleLogger.class).println();
    }

    public static void main(String[] args) {
        Pokemon pokemon2 = Pokedex.getPokemon("Raichu");
        Pokemon pokemon1 = Pokedex.getPokemon("Magmar");
        int turns = 100;
        try {
            runBattle(pokemon1, pokemon2, turns);
        } catch (PokemonFainted e) {
            //empty
        }
    }

    private static void runBattle(Pokemon pokemon1, Pokemon pokemon2, int numOfTurns) throws PokemonFainted {
        for (int i = 0; i < numOfTurns; i++) {
            displayHealth(pokemon1);
            displayHealth(pokemon2);
            pokemon1.selectMove();
            pokemon2.selectMove();
            endl();

            if (speedCompare(pokemon1, pokemon2)) {
                pokemon1.attack(pokemon2);
                checkIfFainted(pokemon1, pokemon2);
                pokemon2.attack(pokemon1);
                checkIfFainted(pokemon1, pokemon2);
            } else {
                pokemon2.attack(pokemon1);
                checkIfFainted(pokemon1, pokemon2);
                pokemon1.attack(pokemon2);
                checkIfFainted(pokemon1, pokemon2);
            }
            pokemon1.runPostBattleStates();
            checkIfFainted(pokemon1, pokemon2);
            pokemon2.runPostBattleStates();
            checkIfFainted(pokemon1, pokemon2);
            endl();
        }
    }

    private static void checkIfFainted(Pokemon p1, Pokemon p2) throws PokemonFainted {
        if (p1.hasFainted() || p2.hasFainted())
            throw new PokemonFainted();
    }

    private static boolean speedCompare(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon1.getAttackState().getSpeedPriority() != pokemon2.getAttackState().getSpeedPriority())
            return pokemon1.getAttackState().getSpeedPriority() > pokemon2.getAttackState().getSpeedPriority();
        return pokemon1.getCurSPD() > pokemon2.getCurSPD();
    }

    private static void displayHealth(Pokemon pokemon) {
        IBattleLogger log = FacadeFactory.getInstance(IBattleLogger.class);
        log.print(pokemon.getName() + "\nHP: ");
        int barLength = 45;
        double percentHealth = (double) pokemon.getCurHP() / (double) pokemon.getBaseHP();
        int healthLength = (int) (barLength * percentHealth);
        for (int i = 0; i < barLength; i++) {
            if (i <= healthLength)
                log.print("#");
            else
                log.print("-");
        }
        log.println("\t (" + pokemon.getCurHP() + "/" + pokemon.getBaseHP() + ")");
    }
}
