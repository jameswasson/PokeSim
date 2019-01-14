package Pokemons;

import Utils.MovedexParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Movedex {

    private static Movedex myMovedex;

    private static Movedex getMovedex() {
        if (myMovedex == null) {
            myMovedex = new Movedex();
            MovedexParser.loadMoves();
        }
        return myMovedex;
    }

    private Map<String, List<String>> dex;

    private Movedex() {
        dex = new HashMap<>();
    }

    public static List<String> getMove(String name) {
        return getMovedex()._getMove(name);
    }

    private List<String> _getMove(String name) {
        return dex.get(name);
    }

    public static void loadDex(List<String> allInfo) {
        getMovedex()._loadDex(allInfo);
    }

    private void _loadDex(List<String> allInfo) {
        dex.put(allInfo.get(0), allInfo);
    }
}
