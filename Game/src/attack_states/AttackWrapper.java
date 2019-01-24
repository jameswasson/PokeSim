package attack_states;


import pokemons.EleType;
import pokemons.Pokemon;

public abstract class AttackWrapper extends AttackState {
    protected AttackState nextAttack;

    @Override
    public EleType getEleType() {
        return nextAttack.getEleType();
    }

    @Override
    int getPower() {
        return nextAttack.getPower();
    }

    @Override
    public int getSpeedPriority() {
        return nextAttack.getSpeedPriority();
    }

    @Override
    DamageCategory getDamageCategory() {
        return nextAttack.getDamageCategory();
    }

    @Override
    public boolean wasCritical() {
        return nextAttack.wasCritical();
    }

    @Override
    boolean willBeCritical(Pokemon pokemon) {
        return nextAttack.willBeCritical(pokemon);
    }

    @Override
    double getCriticalEffect() {
        return nextAttack.getCriticalEffect();
    }

    @Override
    void setCriticalEffect(double effect) {
        nextAttack.setCriticalEffect(effect);
    }

    @Override
    protected double getAccuracy(Pokemon ourselves, Pokemon opponent) {
        return nextAttack.getAccuracy(ourselves, opponent);
    }

    @Override
    void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        nextAttack.attack(ourselves, opponent, damage);
    }
}
