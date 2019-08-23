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

    static EleType[] typeEffectOrder() {
        return new EleType[]
                {NORMAL,FIGHTING,FLYING,POISON,GROUND,ROCK,BUG,GHOST,FIRE,WATER,GRASS,ELECTRIC,PSYCHIC,ICE,DRAGON};
    }
    //info pulled from https://bulbapedia.bulbagarden.net/wiki/Type/Type_chart#Generation_I
    static double[][] typeEffect = {
            { 1, 1, 1, 1, 1,.5, 1, 0, 1, 1, 1, 1, 1, 1, 1}, //normal
            { 2, 1,.5,.5, 1, 2,.5, 0, 1, 1, 1, 1,.5, 2, 1}, //fighting
            { 1, 2, 1, 1, 1,.5, 2, 1, 1, 1, 2,.5, 1, 1, 1}, //flying
            { 1, 1, 1,.5,.5,.5, 2,.5, 1, 1, 2, 1, 1, 1, 1}, //poison
            { 1, 1, 0, 2, 1, 2,.5, 1, 2, 1,.5, 2, 1, 1, 1}, //ground
            { 1,.5, 2, 1,.5, 1, 2, 1,.5, 2, 1, 1, 1, 2, 1}, //rock
            { 1,.5,.5, 2, 1, 1, 1,.5,.5, 1, 2, 1, 2, 1, 1}, //bug
            { 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0, 1, 1}, //ghost
            { 1, 1, 1, 1, 1,.5, 2, 1,.5,.5, 2, 1, 1, 2,.5}, //fire
            { 1, 1, 1, 1, 2, 2, 1, 1, 2,.5,.5, 1, 1, 1,.5}, //water
            { 1, 1,.5,.5, 2, 2,.5, 1,.5, 2,.5, 1, 1, 1,.5}, //grass
            { 1, 1, 2, 1, 0, 1, 1, 1, 1, 2,.5,.5, 1, 1,.5}, //electric
            { 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1,.5, 1, 1}, //psychic
            { 1, 1, 2, 1, 2, 1, 1, 1, 1,.5, 2, 1, 1,.5, 2}, //ice
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2} //dragon
            };

    public static double getTypeEffectiveness(EleType offence, EleType defence){
        if (offence == NONE || defence == NONE || offence == null || defence == null)
            return 1;
        int offenceIndex;
        int defenceIndex;
        offenceIndex = Arrays.asList(typeEffectOrder()).indexOf(offence);
        defenceIndex = Arrays.asList(typeEffectOrder()).indexOf(defence);
        return typeEffect[offenceIndex][defenceIndex];
    }

    public static EleType enumOf(String s) {
        if (s.isBlank())
            return NONE;
        return valueOf(s);
    }
    public static boolean hasNoEffect(EleType offence, EleType defence) {
            return getTypeEffectiveness(offence, defence) == 0;
    }
}
