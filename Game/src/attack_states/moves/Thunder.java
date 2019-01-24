package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Paralyzed;
import pokemons.EleType;
import pokemons.Pokemon;

public class Thunder extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (opponent.getType1() != EleType.Electric && opponent.getType2() != EleType.Electric) {
            Paralyzed.tryToParalyze(opponent);
        }
    }
}
