package attack_states;


import battle_states.post.Burn;
import pokemons.EleType;
import pokemons.Pokemon;
import utils.RNG;

class DamageCalculator {

    private DamageCalculator(){}

    //Reference: https://bulbapedia.bulbagarden.net/wiki/Damage
    public static int getDamage(Pokemon ourselves, Pokemon opponent, AttackState move) {
        double modifier = getDamageModifier(ourselves, opponent, move);
        double level = ourselves.getLevel();
        double power = move.getPower();
        double ad = getEffectiveDefenceAttackStats(ourselves, opponent, move); // a / d
        double damage = (level * 2) / 5 + 2;
        damage *= power * ad / 50;
        damage += 2;
        damage *= modifier;
        if ((int) damage == 0)
            return 1;
        else
            return (int) damage;
    }

    private static double getDamageModifier(Pokemon ourselves, Pokemon opponent, AttackState move) {
        //target, badge and burn are not implemented in gen 1
        double critical = getCritical(ourselves, move);
        double random = RNG.random(.85, 1);
        double stab = getSTAB(ourselves, move);
        double type = getType(move, opponent);
        double burn = getBurn(ourselves);
        return critical * random * stab * type * burn;
    }

    private static double getEffectiveDefenceAttackStats(Pokemon ourselves, Pokemon opponent, AttackState move) {
        DamageCategory category = move.getDamageCategory();
        double ourAttack;
        double theirDefence;
        if (category == DamageCategory.PHYSICAL) {
            ourAttack = ourselves.getCurATK();
            theirDefence = opponent.getCurDEF(move);
        } else if (category == DamageCategory.SPECIAL) {
            ourAttack = ourselves.getCurSPC(null);
            theirDefence = opponent.getCurSPC(move);
        } else {
            //ERROR! Bad things
            return 0;
        }
        return ourAttack / theirDefence;
    }

    private static double getBurn(Pokemon pokemon) {
        if (Burn.isBurned(pokemon))
            return 0.5;
        else
            return 1.0;

    }

    private static double getSTAB(Pokemon pokemon, AttackState move) {
        if (pokemon.isType(move.getEleType()))
            return 1.5;
        else
            return 1;
    }

    private static double getType(AttackState move, Pokemon opponent) {
        double attackBonus = 1;
        if (EleType.isWeakAgainst(move.getEleType(), opponent.getType1()))
            attackBonus *= 2;
        if (EleType.isWeakAgainst(move.getEleType(), opponent.getType2()))
            attackBonus *= 2;
        if (EleType.hasResistanceAgainst(move.getEleType(), opponent.getType1()))
            attackBonus /= 2;
        if (EleType.hasResistanceAgainst(move.getEleType(), opponent.getType2()))
            attackBonus /= 2;

        move.setCriticalEffect(attackBonus);
        return attackBonus;
    }

    private static double getCritical(Pokemon pokemon, AttackState move) {
        //more complicated in gen 1, we are treating ourselves here with simplicity.
        if (move.willBeCritical(pokemon))
            return 2;
        else
            return 1;
    }
}