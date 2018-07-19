package AttackStates.Wrapper;


import AttackStates.AttackState;
import Pokemons.Pokemon;
import Utils.RNG;

public class ConfusedAttack extends AttackState {
    AttackState baseAttackState;
    boolean shouldSnapOut;
    public ConfusedAttack(AttackState baseAttackState,boolean shouldSnapOut){
        this.baseAttackState = baseAttackState;
        this.shouldSnapOut = shouldSnapOut;
    }
    public void execute(Pokemon us, Pokemon them){
        if (shouldSnapOut){
            logger.println(us.getName() + " snapped out of confusion!");
            baseAttackState.execute(us,them);
            return;
        }
        logger.println(us.getName() + " is confused!");
        if (RNG.random() < 0.5)
            baseAttackState.execute(us,them);
        else
            logger.println("It hurt itself in its confusion!");
    }
    public static boolean isConfused(Pokemon pokemon){
        AttackState state = pokemon.getAttackState();
        return state instanceof ConfusedAttack;
    }
}