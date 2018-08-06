package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

/**
 * Swift now bypasses accuracy checks to always hit, unless the target is in the semi-invulnerable turn of a move such as Dig or Fly.
 */

public class Swift extends Move {
    @Override
    public boolean willMiss(Pokemon ourselves, Pokemon opponent) {
        return false;
    }
}
