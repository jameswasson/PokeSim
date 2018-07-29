package AttackStates.Moves;

import AttackStates.AttackState;
import BattleStates.BattleState;
import BattleStates.pre.SetNextMove;
import Pokemons.Pokemon;

public class Rollout extends AttackState {
    int countOfRollouts;
    public Rollout(){
        countOfRollouts = 0;
    }
    public Rollout(int countOfRollouts){
        this.countOfRollouts = countOfRollouts;
    }
    public void execute(Pokemon ourSelf,Pokemon opponent) {
        sayWeUsedMove(ourSelf);
        countOfRollouts++;
        int multiplier = (int) (Math.pow(2, countOfRollouts - 1));
        logger.println("Damage was multiplied X" + multiplier + "!");
        if (countOfRollouts < 5){
            ourSelf.setShouldSelectMove(false);

            //set next move to Rollout
            BattleState moveSetter = new SetNextMove(new Rollout(countOfRollouts));
            ourSelf.getPreBattleStates().add(0,moveSetter);
        }
    }
}
