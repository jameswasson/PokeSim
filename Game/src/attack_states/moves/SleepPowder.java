package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.pre.Asleep;
import Pokemons.Pokemon;

public class SleepPowder extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        Asleep.tryToPutToSleep(opponent);
    }
}
