package attack_states.moves;

import attack_states.Move;
import battle_states.pre.Paralyzed;
import pokemons.EleType;
import pokemons.Pokemon;

public class ThunderPunch extends Move {
    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        super.attack(ourselves, opponent, damage);
        if (opponent.getType1() != EleType.ELECTRIC && opponent.getType2() != EleType.ELECTRIC) {
            Paralyzed.tryToParalyze(opponent);
        }
    }
}
