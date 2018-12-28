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
    protected int currentPowerPoints;
    protected int basePower;
    protected int baseAccuracy;
    protected boolean wasCritical;
    protected double criticalEffect;

    public Move(){
        criticalEffect = 1;
        List<String> allInfo = Movedex.getMove(getName(this.getClass()));
        if (allInfo == null)
            return;
        type = TypesHelper.enumOf(allInfo.get(1));
        damageCategory = DamageCategory.valueOf(allInfo.get(2).toLowerCase());
        powerPoints = Integer.valueOf(allInfo.get(4));
        currentPowerPoints = powerPoints;
        basePower = Integer.valueOf(allInfo.get(5));
        baseAccuracy = Integer.valueOf(allInfo.get(6));
    }

    @Override
    public void execute(Pokemon ourselves, Pokemon opponent) {
        sayWeUsedMove(ourselves);
        currentPowerPoints--;
        if (noEffect(opponent.getType1(),opponent.getType2()))
            logger.println("But it had no effect on " + opponent.getName() + "!");
        else if (willMiss(ourselves, opponent)) {
            onMiss(ourselves, opponent);
        } else {
            int damage;
            if (basePower == -1)
                damage = -1;
            else
                damage = DamageCalculator.getDamage(ourselves,opponent,this);
            attack(ourselves, opponent, damage);
        }
    }

    public void onMiss(Pokemon ourselves, Pokemon opponent) {
        if (damageCategory == DamageCategory.status)
            logger.println("But it failed!");
        else
            logger.println("But it missed!");
    }

    public boolean canHitSemiInvulnerable(Pokemon opponent){
        return !SemiInvulnerable.isSemiInvulnerable(opponent);
    }

    public boolean willMiss(Pokemon ourselves, Pokemon opponent){
        if (!canHitSemiInvulnerable(opponent))
            return true;
        double getHitChance = getChanceOfHitting(ourselves, opponent);
        return RNG.random() > getHitChance;
    }

    public double getChanceOfHitting(Pokemon ourselves, Pokemon opponent){
        if (baseAccuracy == -1)
            return 1.0;//will always hit
        double moveAccuracy = getAccuracy(ourselves,opponent)/100.0;
        double ourAccuracy = ourselves.getCurACC();
        double theirAccuracy = opponent.getCurACC();
        double totalAccuracy = moveAccuracy*ourAccuracy*theirAccuracy;
        return totalAccuracy;
    }

    public boolean noEffect(EleType type1, EleType type2){
        if (damageCategory == DamageCategory.status)
            return false; // can effect
        return TypesHelper.hasNoEffect(getEleType(), type1)||TypesHelper.hasNoEffect(getEleType(), type2);
    }

    @Override
    protected double getAccuracy(Pokemon ourselves, Pokemon opponent) {
        //Override this function if a move's accuracy is -1 and is dependant on other factors.
        return baseAccuracy;
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        dealDamage(ourselves, opponent, damage);
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

    public boolean willBeCritical(Pokemon pokemon){
        double baseSpeed = pokemon.getBaseSPD();
        double probabilityOfCrit = (baseSpeed + 76)/ 1024;
        wasCritical = RNG.random() < probabilityOfCrit;
        return wasCritical;
    }

    public void dealDamage(Pokemon ourselves, Pokemon opponent, int damage){
        if (damage == -1)
            logger.println("-1 damage was dealt!");
        opponent.loseHP(damage);
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

    public int getPowerPoints() {
        return powerPoints;
    }

    //returns new instance from move by name
    public static Move getMove(String s){
        Class<?> classOfMove = getClass(s);
        try {
            return (Move) classOfMove.getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Move copyMove(Move m){
        return getMove(getName(m.getClass()));
    }

    public void setCurrentPowerPoints(int currentPowerPoints) {
        this.currentPowerPoints = currentPowerPoints;
    }
}
