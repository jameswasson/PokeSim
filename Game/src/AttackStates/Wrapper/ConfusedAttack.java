package AttackStates.Wrapper;


import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import Pokemons.Pokemon;
import Utils.RNG;

public class ConfusedAttack extends AttackWrapper {
    boolean shouldSnapOut;
    public ConfusedAttack(AttackState nextAttack,boolean shouldSnapOut){
        this.nextAttack = nextAttack;
        this.shouldSnapOut = shouldSnapOut;
    }
    public void execute(Pokemon us, Pokemon them){
        if (shouldSnapOut){
            logger.println(us.getName() + " snapped out of confusion!");
            nextAttack.execute(us,them);
            return;
        }
        logger.println(us.getName() + " is confused!");
        if (RNG.random() < 0.5)
            nextAttack.execute(us,them);
        else
            logger.println("It hurt itself in its confusion!");
    }
    public static boolean isConfused(Pokemon pokemon){
        AttackState state = pokemon.getAttackState();
        return state instanceof ConfusedAttack;
    }
}