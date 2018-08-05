package Pokemons;

import java.util.*;


public class TypesHelper {

    public static EleType enumOf(String s){
        if (s.equals(""))
            return EleType.None;
        return EleType.valueOf(s);
    }

    public static boolean hasResistanceAgainst(EleType offence, EleType defence){
        if (defence == EleType.Dragon)
            return Arrays.asList(EleType.Fire,EleType.Water,EleType.Electric,EleType.Grass).contains(offence);
        if (defence == EleType.Ghost)
            return Arrays.asList(EleType.Poison,EleType.Bug).contains(offence);
        if (defence == EleType.Rock)
            return Arrays.asList(EleType.Normal,EleType.Fire,EleType.Poison,EleType.Flying).contains(offence);
        if (defence == EleType.Bug)
            return Arrays.asList(EleType.Grass,EleType.Fighting,EleType.Ground).contains(offence);
        if (defence == EleType.Psychic)
            return Arrays.asList(EleType.Fighting,EleType.Psychic).contains(offence);
        if (defence == EleType.Flying)
            return Arrays.asList(EleType.Grass,EleType.Fighting,EleType.Bug).contains(offence);
        if (defence == EleType.Ground)
            return Arrays.asList(EleType.Poison,EleType.Rock).contains(offence);
        if (defence == EleType.Poison)
            return Arrays.asList(EleType.Fighting,EleType.Grass,EleType.Poison).contains(offence);
        if (defence == EleType.Fighting)
            return Arrays.asList(EleType.Bug,EleType.Rock).contains(offence);
        if (defence == EleType.Ice)
            return offence == EleType.Ice;
        if (defence == EleType.Grass)
            return Arrays.asList(EleType.Water,EleType.Grass,EleType.Electric,EleType.Ground).contains(offence);
        if (defence == EleType.Electric)
            return Arrays.asList(EleType.Electric,EleType.Flying).contains(offence);
        if (defence == EleType.Water)
            return Arrays.asList(EleType.Water,EleType.Fire,EleType.Ice).contains(offence);
        if (defence == EleType.Fire)
            return Arrays.asList(EleType.Grass,EleType.Fire,EleType.Bug).contains(offence);
        return false;
    }

    public static boolean isWeakAgainst(EleType offence, EleType defence){
        if (defence == EleType.Normal)
            return offence == EleType.Fighting;
        if (defence == EleType.Electric)
            return offence == EleType.Ground;
        if (defence == EleType.Psychic)
            return offence == EleType.Bug;
        if (defence == EleType.Ghost)
            return offence == EleType.Ghost;
        if (defence == EleType.Fire)
            return Arrays.asList(EleType.Water,EleType.Ground,EleType.Rock).contains(offence);
        if (defence == EleType.Water)
            return Arrays.asList(EleType.Electric,EleType.Grass).contains(offence);
        if (defence == EleType.Grass)
            return Arrays.asList(EleType.Fire,EleType.Ice,EleType.Poison,EleType.Flying,EleType.Bug).contains(offence);
        if (defence == EleType.Ice)
            return Arrays.asList(EleType.Fire,EleType.Fighting,EleType.Rock).contains(offence);
        if (defence == EleType.Fighting)
            return Arrays.asList(EleType.Flying,EleType.Psychic).contains(offence);
        if (defence == EleType.Poison)
            return Arrays.asList(EleType.Ground,EleType.Psychic,EleType.Bug).contains(offence);
        if (defence == EleType.Ground)
            return Arrays.asList(EleType.Water,EleType.Grass,EleType.Ice).contains(offence);
        if (defence == EleType.Flying)
            return Arrays.asList(EleType.Electric,EleType.Ice,EleType.Rock).contains(offence);
        if (defence == EleType.Bug)
            return Arrays.asList(EleType.Fire,EleType.Poison,EleType.Flying,EleType.Rock).contains(offence);
        if (defence == EleType.Rock)
            return Arrays.asList(EleType.Water,EleType.Grass,EleType.Fighting,EleType.Ground).contains(offence);
        if (defence == EleType.Dragon)
            return Arrays.asList(EleType.Ice,EleType.Dragon).contains(offence);
        return false;
    }

    public static boolean hasNoEffect(EleType offence, EleType defence){
        if (offence == EleType.Normal && defence == EleType.Ghost)
            return true;
        else if (offence == EleType.Electric && defence == EleType.Ground)
            return true;
        else if (offence == EleType.Ground && defence == EleType.Flying)
            return true;
        else if (offence == EleType.Ghost && defence == EleType.Normal)
            return true;
        else if (offence == EleType.Ghost && defence == EleType.Psychic)
            return true;
        else if (offence == EleType.Fighting && defence == EleType.Ghost)
            return true;
        else
            return false;
    }
}
