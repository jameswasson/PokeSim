package attack_states;


import battle_states.SemiInvulnerable;
import pokemons.EleType;
import pokemons.Movedex;
import pokemons.Pokemon;
import pokemons.TypesHelper;
import utils.RNG;

import java.util.List;


public class Move extends AttackState {
    protected EleType type;
    protected DamageCategory damageCategory;
    protected int powerPoints;
    private int currentPowerPoints;
    protected int basePower;
    protected int baseAccuracy;
    private boolean wasCritical;
    private double criticalEffect;

    public Move() {
        criticalEffect = 1;
        List<String> allInfo = Movedex.getMove(getName(this.getClass()));
        if (allInfo == null)
            return;
        type = TypesHelper.enumOf(allInfo.get(1));
        damageCategory = DamageCategory.valueOf(allInfo.get(2));
        powerPoints = Integer.valueOf(allInfo.get(4));
        currentPowerPoints = powerPoints;
        basePower = Integer.valueOf(allInfo.get(5));
        baseAccuracy = Integer.valueOf(allInfo.get(6));
    }

    //returns new instance from move by name
    public static Move getMove(String s) {
        Class<?> classOfMove = getClass(s);
        try {
            return (Move) classOfMove.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Move copyMove(Move m) {
        return getMove(getName(m.getClass()));
    }

    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        sayWeUsedMove(ourselves);
        currentPowerPoints--;
        if (noEffect(opponent.getType1(), opponent.getType2()))
            logger.println("But it had no effect on " + opponent.getName() + "!");
        else if (willMiss(ourselves, opponent)) {
            onMiss(ourselves);
        } else {
            int damage;
            if (basePower == -1)
                damage = -1;
            else
                damage = DamageCalculator.getDamage(ourselves, opponent, this);
            attack(ourselves, opponent, damage);
        }
    }

    @SuppressWarnings("Unused method parameter")
    public void onMiss(Pokemon ourselves) {
        if (damageCategory == DamageCategory.STATUS)
            logger.println("But it failed!");
        else
            logger.println("But it missed!");
    }

    private boolean canHitSemiInvulnerable(Pokemon opponent) {
        return !SemiInvulnerable.isSemiInvulnerable(opponent);
    }

    private boolean willMiss(Pokemon ourselves, Pokemon opponent) {
        if (!canHitSemiInvulnerable(opponent))
            return true;
        double getHitChance = getChanceOfHitting(ourselves, opponent);
        return RNG.random() > getHitChance;
    }

    private double getChanceOfHitting(Pokemon ourselves, Pokemon opponent) {
        if (baseAccuracy == -1)
            return 1.0;//will always hit
        double moveAccuracy = getAccuracy(ourselves, opponent) / 100.0;
        double ourAccuracy = ourselves.getCurACC();
        double theirAccuracy = opponent.getCurACC();
        return moveAccuracy * ourAccuracy * theirAccuracy;
    }

    private double getChanceOfCrit(Pokemon ourselves) {
        double baseSpeed = ourselves.getBaseSPD();
        return (baseSpeed + 76) / 1024;
    }

    private boolean noEffect(EleType type1, EleType type2) {
        if (damageCategory == DamageCategory.STATUS)
            return false; // can effect
        return TypesHelper.hasNoEffect(getEleType(), type1) || TypesHelper.hasNoEffect(getEleType(), type2);
    }

    @Override
    protected double getAccuracy(Pokemon ourselves, Pokemon opponent) {
        //Override this function if a move's accuracy is -1 and is dependant on other factors.
        return baseAccuracy;
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        dealDamage(opponent, damage);
    }

    @Override
    public EleType getEleType() {
        return type;
    }

    @Override
    int getPower() {
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
    public boolean wasCritical() {
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

    public boolean willBeCritical(Pokemon pokemon) {
        double chance = getChanceOfCrit(pokemon);
        chance *= critBonus();
        chance *= pokemon.getCritBonus();
        wasCritical = RNG.random() < chance;
        return wasCritical;
    }

    public double critBonus() {
        return 1;//default: no bonus
    }

    private void dealDamage(Pokemon opponent, int damage) {
        if (damage == -1)
            logger.println("-1 damage was dealt!");
        opponent.loseHP(damage, this);
        if (wasCritical())
            logger.println("Critical Hit!");
        if (getCriticalEffect() > 1)
            logger.println("It was super effective!");
        else if (getCriticalEffect() < 1)
            logger.println("It wasn't very effective.");
    }

    public int getCurrentPowerPoints() {
        return currentPowerPoints;
    }

    public void setCurrentPowerPoints(int currentPowerPoints) {
        this.currentPowerPoints = currentPowerPoints;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public String getDisplayText() {
        return AttackState.getName(getClass()) + " (" + getCurrentPowerPoints() + "/" + getPowerPoints() + ")";
    }
}
