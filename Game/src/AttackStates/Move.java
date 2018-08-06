package AttackStates;

import BattleStates.SemiInvulnerable;
import Pokemons.EleType;
import Pokemons.Movedex;
import Pokemons.Pokemon;
import Pokemons.TypesHelper;
import Utils.RNG;

import java.util.List;

public class Move extends AttackState {
    protected EleType type;
    protected DamageCategory damageCategory;
    protected int powerPoints;
    protected int basePower;
    protected int baseAccuracy;
    protected boolean wasCritical;
    protected double criticalEffect;

    public Move(){
        List<String> allInfo = Movedex.getMove(getName(this.getClass()));
        type = TypesHelper.enumOf(allInfo.get(1));
        damageCategory = DamageCategory.valueOf(allInfo.get(2).toLowerCase());
        powerPoints = Integer.valueOf(allInfo.get(4));
        basePower = Integer.valueOf(allInfo.get(5));
        baseAccuracy = Integer.valueOf(allInfo.get(6));
        criticalEffect = 1;
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        sayWeUsedMove(ourSelves);
        if (TypesHelper.hasNoEffect(getEleType(),opponent.getType1())||TypesHelper.hasNoEffect(getEleType(),opponent.getType2()))
            logger.println("But it had no effect on " + opponent.getName() + "!s");
        else if (willMiss(ourSelves, opponent))
            if (damageCategory == DamageCategory.status)
                logger.println("But it failed!");
            else
                logger.println("But it missed!");
        else {
            attack(ourSelves, opponent);
            if (wasCritical())
                logger.println("Critical Hit!");
            if (getCriticalEffect() > 1)
                logger.println("It was super effective!");
            else if (getCriticalEffect() < 1)
                logger.println("It wasn't very effective.");
        }
    }

    public boolean willMiss(Pokemon ourselves, Pokemon opponent){
        if (SemiInvulnerable.isSemiInvulnerable(opponent))
            return true;
        double getHitChance = getChanceOfHitting(ourselves, opponent);
        return RNG.random() < getHitChance;
    }

    public double getChanceOfHitting(Pokemon ourselves, Pokemon opponent){
        return getAccuracy(ourselves,opponent) * ourselves.getCurACC() * opponent.getCurEVA();
    }

    @Override
    protected int getAccuracy(Pokemon ourselves, Pokemon opponent) {
        return baseAccuracy;
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent) {
        int damage = DamageCalculator.getDamage(ourselves,opponent,this);
        logger.println("Should deal " + damage + " damage.");
        //todo deal general damage
    }

    @Override
    public EleType getEleType() {
        return type;
    }

    @Override
    int getPower() {
        if (basePower == -1)
            logger.println("basePower of " + getName(this.getClass()) + "is -1.");
        return basePower;
    }

    @Override
    public int getSpeedPriority() {
        return 0;
    }

    @Override
    DamageCategory getDamageCategory() {
        return damageCategory;
    }

    @Override
    boolean wasCritical() {
        return wasCritical;
    }

    @Override
    public double getCriticalEffect() {
        return criticalEffect;
    }

    @Override
    void setCriticalEffect(double effect) {
        criticalEffect = effect;
    }

    public boolean willBeCritical(Pokemon pokemon){
        double baseSpeed = pokemon.getBaseSPD();
        double probabilityOfCrit = (baseSpeed + 76)/ 1024;
        wasCritical = RNG.random() < probabilityOfCrit;
        return wasCritical;
    }
}
