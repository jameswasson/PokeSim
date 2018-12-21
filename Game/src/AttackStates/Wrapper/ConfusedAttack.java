package AttackStates.Wrapper;
import AttackStates.AttackState;
import AttackStates.AttackWrapper;
import AttackStates.DamageCategory;
import AttackStates.Move;
import BattleStates.pre.Confused;
import Pokemons.EleType;
import Pokemons.Pokemon;
import Utils.RNG;

public class ConfusedAttack extends AttackWrapper {
    private boolean shouldSnapOut;
    public ConfusedAttack(AttackState nextAttack,boolean shouldSnapOut){
        this.nextAttack = nextAttack;
        this.shouldSnapOut = shouldSnapOut;
    }
    public void execute(Pokemon us, Pokemon them){
        if (shouldSnapOut){
            Confused.removeConfusion(us);
            logger.println(us.getName() + " snapped out of confusion!");
            nextAttack.execute(us,them);
            return;
        }
        logger.println(us.getName() + " is confused!");
        if (RNG.random() < 0.5)
            nextAttack.execute(us,them);
        else {
            logger.println("It hurt itself in its confusion!");
            hurtSelf(us);
        }
    }
    private static void hurtSelf(Pokemon pokemon){
        //attack self with a typeless 40 damage hit with no chance of crit.
        class HurtConfusion extends Move {
            public HurtConfusion(){
                basePower = 40;
                powerPoints = 40;
                damageCategory = DamageCategory.physical;
                type = EleType.None;
                baseAccuracy = -1;
            }
            @Override
            public boolean willBeCritical(Pokemon pokemon) {
                return false;
            }

            @Override
            protected void sayWeUsedMove(Pokemon us) {
            }
        }
        HurtConfusion hurtConfusion = new HurtConfusion();
        hurtConfusion.execute(pokemon,pokemon);
    }
}