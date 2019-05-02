package pokemons;

import attack_states.DamageCategory;
import attack_states.Move;
import utils.RNG;

public class ConfusedPokemon extends WrapperPokemon {
    private int turnsTillNotConfused;
    private ConfusedPokemon(){
        turnsTillNotConfused = RNG.randomInt(1, 3);
    }
    @Override
    public void attack(Pokemon toAttack) {
        if (turnsTillNotConfused <= 0) {
            logger.println(getName() + " snapped out of confusion!");
            removeSelf();
            super.attack(toAttack);
        }
        else{
            logger.println(getName() + " is confused!");
            if (RNG.random() < .5)
                super.attack(toAttack);
            else
                hurtSelf(getHead());
        }
    }
    @Override
    public void runPostBattleStates() {
        turnsTillNotConfused--;
        super.runPostBattleStates();
    }
    private static void hurtSelf(Pokemon pokemon) {
        //attack self with a typeless 40 damage hit with no chance of crit.
        class HurtConfusion extends Move {
            private HurtConfusion() {
                basePower = 40;
                powerPoints = 40;
                damageCategory = DamageCategory.PHYSICAL;
                type = EleType.NONE;
                baseAccuracy = -1;
            }

            @Override
            public boolean willBeCritical(Pokemon pokemon) {
                return false;
            }

            @Override
            protected void sayWeUsedMove(Pokemon us) {
                //empty because we should not declare that we used a move
            }
        }
        HurtConfusion hurtConfusion = new HurtConfusion();
        hurtConfusion.execute(pokemon, pokemon);
    }
    public static boolean isConfused(Pokemon pokemon){
        return WrapperPokemon.containsWrapped(pokemon, ConfusedPokemon.class);
    }
    public static void tryToConfuse(Pokemon pokemon) {
        if (isConfused(pokemon)) {
            logger.println(pokemon.getName() + " is already confused!");
        } else {
            logger.println(pokemon.getName() + " is confused!");
            WrapperPokemon.wrap(pokemon, new ConfusedPokemon());
        }
    }
}
