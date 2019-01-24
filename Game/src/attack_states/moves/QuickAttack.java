package attack_states.moves;

import attack_states.Move;

public class QuickAttack extends Move {
    @Override
    public int getSpeedPriority() {
        return 1;
    }
}
