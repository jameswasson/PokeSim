package pokemons;


import utils.MovedexParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movedex {

    private static Map<String, List<String>> dex;

    private Movedex() {
    }

    public static List<String> getMove(String name) {
        if (dex == null) {
            dex = new HashMap<>();
            MovedexParser.loadMoves();
        }
        return dex.get(name);
    }

    public static void loadDex(List<String> allInfo) {
        dex.put(allInfo.get(0), allInfo);
    }
}
