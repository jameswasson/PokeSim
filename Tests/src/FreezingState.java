import attack_states.moves.FireBlast;
import attack_states.moves.FirePunch;
import attack_states.moves.Flamethrower;
import attack_states.moves.IceBeam;
import org.junit.jupiter.api.Test;
import pokemons.pokemon_states.FrozenPokemon;
import utils.RNG;

public class FreezingState extends MoveTest {
    @Test
    public void canFreeze() {
        FrozenPokemon.tryToFreeze(Magikarp);
        assert (FrozenPokemon.isFrozen(Magikarp));
    }

    @Test
    public void canUnFreeze() {
        FrozenPokemon.tryToFreeze(Magikarp);
        FrozenPokemon.removeFreeze(Magikarp);
        assert (!FrozenPokemon.isFrozen(Magikarp));
    }

    @Test
    public void freezingMove() {
        RNG.setSeed(11);
        Caterpie.selectMove(IceBeam.class);
        Caterpie.attack(Magikarp);
        assert (FrozenPokemon.isFrozen(Magikarp));
    }

    @Test
    public void freezingStopsAttack() {
        RNG.setSeed(0);
        Caterpie.selectMove(IceBeam.class);
        FrozenPokemon.tryToFreeze(Caterpie);
        Caterpie.attack(Magikarp);
        assert (Magikarp.getBaseHP() - Magikarp.getCurHP() == 0);
    }

    @Test
    public void testFireBlast() {
        burningMoveUnfreezes(FireBlast.class);
    }

    @Test
    public void testFirePunch() {
        burningMoveUnfreezes(FirePunch.class);
    }

    @Test
    public void testFlamethrower() {
        burningMoveUnfreezes(Flamethrower.class);
    }

    public void burningMoveUnfreezes(Class moveKlass) {
        FrozenPokemon.tryToFreeze(Magikarp);
        assert (FrozenPokemon.isFrozen(Magikarp));
        Caterpie.selectMove(moveKlass);
        Caterpie.attack(Magikarp);
        assert (!FrozenPokemon.isFrozen(Magikarp));
    }
}
