package AttackStates.Moves;

import AttackStates.Move;

public class QuickAttack extends Move {
    @Override
    public int getSpeedPriority() {
        return 1;
    }
}
