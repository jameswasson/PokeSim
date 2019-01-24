package AttackStates.Moves;

import AttackStates.Move;
import BattleStates.post.BadPoison;
import Pokemons.Pokemon;

public class Toxic extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        BadPoison.tryToBadlyPoison(opponent);
    }
}
