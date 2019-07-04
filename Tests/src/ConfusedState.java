import attack_states.moves.ConfuseRay;
import attack_states.moves.Tackle;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.ConfusedPokemon;
import utils.RNG;

public class ConfusedState extends MoveTest {
    @Test
    public void allowAttack() {
        RNG.setSeed(1);
        attack();
        assert (Caterpie.getBaseHP() - Caterpie.getCurHP() != 0);
    }

    @Test
    public void preventAttack() {
        attack();
        assert (Caterpie.getBaseHP() - Caterpie.getCurHP() == 0);
    }

    @Test
    public void isConfusedWorks() {
        attack();
        assert (ConfusedPokemon.isConfused(Magikarp));
        assert (!ConfusedPokemon.isConfused(Caterpie));
        Magikarp.selectMove(Tackle.class);
        assert (ConfusedPokemon.isConfused(Magikarp));
    }

    public void attack() {
        Magikarp.selectMove(Tackle.class);
        Caterpie.selectMove(ConfuseRay.class);
        Caterpie.attack(Magikarp);
        Magikarp.attack(Caterpie);
    }
}