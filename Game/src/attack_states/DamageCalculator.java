package attack_states;


import battle_states.post.Burn;
import pokemons.Pokemon;
import pokemons.TypesHelper;
import utils.RNG;

public class DamageCalculator {

    //Reference: https://bulbapedia.bulbagarden.net/wiki/Damage
    public static int getDamage(Pokemon ourselves, Pokemon opponent, AttackState move) {
        double modifier = getDamageModifier(ourselves, opponent, move);
        double level = ourselves.getLevel();
        double power = move.getPower();
        double a_d = getEffectiveDefenceAttackStats(ourselves, opponent, move); // a / d
        double damage = (level * 2) / 5 + 2;
        damage *= power * a_d / 50;
        damage += 2;
        damage *= modifier;
        if ((int) damage == 0)
            return 1;
        else
            return (int) damage;
    }

    private static double getDamageModifier(Pokemon ourselves, Pokemon opponent, AttackState move) {
        //target, badge and burn are not implemented in gen 1
        double weather = getWeather(move);
        double critical = getCritical(ourselves, move);
        double random = RNG.random(.85, 1);
        double STAB = getSTAB(ourselves, move);
        double type = getType(move, opponent);
        double other = getOther(ourselves, move, opponent);
        return weather * critical * random * STAB * type * other;
    }

    private static double getEffectiveDefenceAttackStats(Pokemon ourselves, Pokemon opponent, AttackState move) {
        DamageCategory category = move.getDamageCategory();
        double ourAttack;
        double theirDefence;
        if (category == DamageCategory.physical) {
            ourAttack = ourselves.getCurATK();
            theirDefence = opponent.getCurDEF(move);
        } else if (category == DamageCategory.special) {
            ourAttack = ourselves.getCurSPC(null);
            theirDefence = opponent.getCurSPC(move);
        } else {
            //ERROR! Bad things
            return 0;
        }
        return ourAttack / theirDefence;
    }

    private static double getOther(Pokemon pokemon, AttackState move, Pokemon opponent) {
        double toReturn = 1;
        if (Burn.isBurned(pokemon))
            toReturn /= 2;
        return toReturn;
    }

    private static double getSTAB(Pokemon pokemon, AttackState move) {
        if (pokemon.isType(move.getEleType()))
            return 1.5;
        else
            return 1;
    }

    private static double getType(AttackState move, Pokemon opponent) {
        double attackBonus = 1;
        if (TypesHelper.isWeakAgainst(move.getEleType(), opponent.getType1()))
            attackBonus *= 2;
        if (TypesHelper.isWeakAgainst(move.getEleType(), opponent.getType2()))
            attackBonus *= 2;
        if (TypesHelper.hasResistanceAgainst(move.getEleType(), opponent.getType1()))
            attackBonus /= 2;
        if (TypesHelper.hasResistanceAgainst(move.getEleType(), opponent.getType2()))
            attackBonus /= 2;

        move.setCriticalEffect(attackBonus);
        return attackBonus;
    }

    private static double getWeather(AttackState move) {
        //Supposedly there is no weather-changing moves in Gen 1
        return 1;
    }

    private static double getCritical(Pokemon pokemon, AttackState move) {
        //more complicated in gen 1, we are treating ourselves here with simplicity.
        if (move.willBeCritical(pokemon))
            return 2;
        else
            return 1;
    }
}