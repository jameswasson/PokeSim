package attack_states;

import utils.RNG;

public class MoveRNG {
    public boolean moveWillMiss(double hitChance) {
        return RNG.random() > hitChance;
    }

    public boolean moveWillCrit(double critChance) {
        return RNG.random() < critChance;
    }

    public boolean moveWillApplyStatus(double statusChance){
        return RNG.random() < statusChance;
    }
}