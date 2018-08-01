package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.BattleState;
import BattleStates.pre.SetNextMove;
import Pokemons.Pokemon;

public class Rollout extends Move {
    int countOfRollouts;
    public Rollout(){
        countOfRollouts = 0;
    }
    public Rollout(int countOfRollouts){
        this.countOfRollouts = countOfRollouts;
    }
    public void attack(Pokemon ourSelf,Pokemon opponent) {
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
