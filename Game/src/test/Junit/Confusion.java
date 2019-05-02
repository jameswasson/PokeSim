package Junit;

import attack_states.moves.ConfuseRay;
import org.junit.Test;
import pokemons.ConfusedPokemon;
import utils.RNG;

public class Confusion extends Move {
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