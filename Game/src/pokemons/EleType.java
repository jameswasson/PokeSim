package pokemons;

import java.util.Arrays;

public enum EleType {
    NORMAL,
    ELECTRIC,
    FIGHTING,
    PSYCHIC,
    DRAGON,
    ICE,
    POISON,
    FLYING,
    GROUND,
    GRASS,
    FIRE,
    NONE,
    WATER,
    BUG,
    ROCK,
    GHOST;

    public static EleType enumOf(String s) {
        if (s.equals(""))
            return EleType.NONE;
        return EleType.valueOf(s);
    }

    public static boolean hasResistanceAgainst(EleType offence, EleType defence) {
        if (defence == EleType.DRAGON)
            return Arrays.asList(EleType.FIRE, EleType.WATER, EleType.ELECTRIC, EleType.GRASS).contains(offence);
        if (defence == EleType.GHOST)
            return Arrays.asList(EleType.POISON, EleType.BUG).contains(offence);
        if (defence == EleType.ROCK)
            return Arrays.asList(EleType.NORMAL, EleType.FIRE, EleType.POISON, EleType.FLYING).contains(offence);
        if (defence == EleType.BUG)
            return Arrays.asList(EleType.GRASS, EleType.FIGHTING, EleType.GROUND).contains(offence);
        if (defence == EleType.PSYCHIC)
            return Arrays.asList(EleType.FIGHTING, EleType.PSYCHIC).contains(offence);
        if (defence == EleType.FLYING)
            return Arrays.asList(EleType.GRASS, EleType.FIGHTING, EleType.BUG).contains(offence);
        if (defence == EleType.GROUND)
            return Arrays.asList(EleType.POISON, EleType.ROCK).contains(offence);
        if (defence == EleType.POISON)
            return Arrays.asList(EleType.FIGHTING, EleType.GRASS, EleType.POISON).contains(offence);
        if (defence == EleType.FIGHTING)
            return Arrays.asList(EleType.BUG, EleType.ROCK).contains(offence);
        if (defence == EleType.ICE)
            return offence == EleType.ICE;
        if (defence == EleType.GRASS)
            return Arrays.asList(EleType.WATER, EleType.GRASS, EleType.ELECTRIC, EleType.GROUND).contains(offence);
        if (defence == EleType.ELECTRIC)
            return Arrays.asList(EleType.ELECTRIC, EleType.FLYING).contains(offence);
        if (defence == EleType.WATER)
            return Arrays.asList(EleType.WATER, EleType.FIRE, EleType.ICE).contains(offence);
        if (defence == EleType.FIRE)
            return Arrays.asList(EleType.GRASS, EleType.FIRE, EleType.BUG).contains(offence);
        return false;
    }

    public static boolean isWeakAgainst(EleType offence, EleType defence) {
        if (defence == EleType.NORMAL)
            return offence == EleType.FIGHTING;
        if (defence == EleType.ELECTRIC)
            return offence == EleType.GROUND;
        if (defence == EleType.PSYCHIC)
            return offence == EleType.BUG;
        if (defence == EleType.GHOST)
            return offence == EleType.GHOST;
        if (defence == EleType.FIRE)
            return Arrays.asList(EleType.WATER, EleType.GROUND, EleType.ROCK).contains(offence);
        if (defence == EleType.WATER)
            return Arrays.asList(EleType.ELECTRIC, EleType.GRASS).contains(offence);
        if (defence == EleType.GRASS)
            return Arrays.asList(EleType.FIRE, EleType.ICE, EleType.POISON, EleType.FLYING, EleType.BUG).contains(offence);
        if (defence == EleType.ICE)
            return Arrays.asList(EleType.FIRE, EleType.FIGHTING, EleType.ROCK).contains(offence);
        if (defence == EleType.FIGHTING)
            return Arrays.asList(EleType.FLYING, EleType.PSYCHIC).contains(offence);
        if (defence == EleType.POISON)
            return Arrays.asList(EleType.GROUND, EleType.PSYCHIC, EleType.BUG).contains(offence);
        if (defence == EleType.GROUND)
            return Arrays.asList(EleType.WATER, EleType.GRASS, EleType.ICE).contains(offence);
        if (defence == EleType.FLYING)
            return Arrays.asList(EleType.ELECTRIC, EleType.ICE, EleType.ROCK).contains(offence);
        if (defence == EleType.BUG)
            return Arrays.asList(EleType.FIRE, EleType.POISON, EleType.FLYING, EleType.ROCK).contains(offence);
        if (defence == EleType.ROCK)
            return Arrays.asList(EleType.WATER, EleType.GRASS, EleType.FIGHTING, EleType.GROUND).contains(offence);
        if (defence == EleType.DRAGON)
            return Arrays.asList(EleType.ICE, EleType.DRAGON).contains(offence);
        return false;
    }

    public static boolean hasNoEffect(EleType offence, EleType defence) {
        if (offence == EleType.NORMAL && defence == EleType.GHOST)
            return true;
        else if (offence == EleType.ELECTRIC && defence == EleType.GROUND)
            return true;
        else if (offence == EleType.GROUND && defence == EleType.FLYING)
            return true;
        else if (offence == EleType.GHOST && defence == EleType.NORMAL)
            return true;
        else if (offence == EleType.GHOST && defence == EleType.PSYCHIC)
            return true;
        else if (offence == EleType.FIGHTING && defence == EleType.GHOST)
            return true;
        else
            return false;
    }
}
