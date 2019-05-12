package Junit;

import attack_states.moves.Tackle;
import org.junit.Test;
import pokemons.pokemon_states.FlinchedPokemon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FlinchedState extends Move {
    @Test
    public void canFindFlinch() {
        FlinchedPokemon.makeFlinch(Caterpie);
        assert (FlinchedPokemon.isFlinched(Caterpie));
    }

    @Test
    public void removeFlichAfterTurn() {
        FlinchedPokemon.makeFlinch(Caterpie);
        Caterpie.runPostBattleStates();
        assertFalse(FlinchedPokemon.isFlinched(Caterpie));
    }

    @Test
    public void canRemoveFlinch() {
        Caterpie.selectMove(Tackle.class);
        FlinchedPokemon.makeFlinch(Caterpie);
        Caterpie.attack(Magikarp);
        Caterpie.runPostBattleStates();
        Caterpie.selectMove(Tackle.class);
        assert (!FlinchedPokemon.isFlinched(Caterpie));
    }

    @Test
    public void flinchPreventsAttack() {
        Caterpie.selectMove(Tackle.class);
        FlinchedPokemon.makeFlinch(Caterpie);
        Caterpie.attack(Magikarp);
        assertEquals(Magikarp.getCurHP(), Magikarp.getBaseHP());
    }
}
