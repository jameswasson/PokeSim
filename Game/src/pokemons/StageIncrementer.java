package pokemons;


import battle_field.IBattleLogger;
import facade.FacadeFactory;

class StageIncrementer {
    private StageIncrementer() {
    }

    static int incrementBy(String type, int currentStage, int stageIncrement, String pokemonName) {
        IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);
        int bound = Math.max(-6, Math.min(6, currentStage + stageIncrement));
        switch (bound - currentStage) {
            case -2:
                logger.println(pokemonName + "'s " + type + " greatly fell!");
                break;
            case -1:
                logger.println(pokemonName + "'s " + type + " fell!");
                break;
            case 0:
                logger.println("Nothing happened!");
                break;
            case 1:
                logger.println(pokemonName + "'s " + type + " rose!");
                break;
            case 2:
                logger.println(pokemonName + "'s " + type + " greatly rose!");
                break;
            default:
                logger.println("Something bad happened" + (bound - currentStage));
                break;
        }
        return bound;
    }

    static double getStatMultiplier(int stage) {
        double[] stageMultiplier = {.25, .28, .33, .40, .50, .66, 1, 1.50, 2, 2.5, 3, 3.5, 4};
        return stageMultiplier[stage + 6];
    }

    static double getStatMultiplierAccEva(int stage) {
        double[] stageMultiplier = {.33, .36, .43, .5, .66, .75, 1, 1.33, 1.66, 2, 2.33, 2.66, 3};
        return stageMultiplier[stage + 6];
    }
}