package AttackStates;

import Pokemons.EleType;

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
}
