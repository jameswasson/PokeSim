package Pokemons;

import java.util.HashMap;



public class TypesHelper {

    public static EleType enumOf(String s){
        if (s.equals(""))
            return EleType.None;
        return EleType.valueOf(s);
    }
//    Weaknesses:
//    Normal - Fighting
//    Fire - Water, Ground, Rock
//    Water - Electric, Grass
//    Electric - Ground
//    Grass - Fire, Ice, Poison, Flying, Bug
//    Ice - Fire, Fighting, Rock
//    Fighting - Flying, Psychic
//    Poison - Ground, Psychic, Bug
//    Ground - Water, Grass, Ice
//    Flying - Electric, Ice, Rock
//    Psychic - Bug
//    Bug - Fire, Poison, Flying, Rock
//    Rock - Water, Grass, Fighting, Ground
//    Ghost - Ghost
//    Dragon - Ice, Dragon
}
