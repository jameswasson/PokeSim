package AttackStates;

import Pokemons.EleType;

public abstract class AttackWrapper extends AttackState {
    protected AttackState nextAttack;

    @Override
    EleType getEleType() {
        return nextAttack.getEleType();
    }

    @Override
    int getPower() {
        return nextAttack.getPower();
    }
}
