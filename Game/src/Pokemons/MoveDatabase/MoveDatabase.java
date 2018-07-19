package Pokemons.MoveDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AttackStates.Moves.*;

public class MoveDatabase {



    private static MoveDatabase INSTANCE;
    private Map<String, List<Class>> nameToAttackMap;
    public static List<Class> getAttackStateFor(String pokemonName){
        return getINSTANCE()._getAttackStateFor(pokemonName);
    }
    private List<Class> _getAttackStateFor(String pokemonName){
        return nameToAttackMap.get(pokemonName);
    }
    private static MoveDatabase getINSTANCE(){
        if (INSTANCE == null)
            INSTANCE = new MoveDatabase();
        return INSTANCE;
    }
    private MoveDatabase(){
        nameToAttackMap = new HashMap<>();
        addZubat();
        addOddish();
        addGeodude();
    }

    private void addZubat(){
        List<Class> zubatList = new ArrayList<>();
        zubatList.add(ConfuseRay.class);
        zubatList.add(MegaDrain.class);
        zubatList.add(Swift.class);
        //zubatList.add(Haze.class);
        nameToAttackMap.put("Zubat",zubatList);
    }
    private void addGeodude(){
        List<Class> geodudeList = new ArrayList<>();
        geodudeList.add(ConfuseRay.class);
        geodudeList.add(Rollout.class);
        nameToAttackMap.put("Geodude",geodudeList);
    }
    private void addOddish(){
        List<Class> oddishList = new ArrayList<>();
        oddishList.add(MegaDrain.class);
        oddishList.add(Yawn.class);
        nameToAttackMap.put("Oddish",oddishList);
    }
}
