package Utils;

import Pokemons.Movedex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MovedexParser extends CSVParser {

    public List<String> processLine(String line, boolean verbose) {
        List<String> toReturn = new ArrayList<>();
        Scanner scnr = new Scanner(line);
        scnr.useDelimiter(",");
        scnr.next();//move no.
        toReturn.add(scnr.next());// move name
        toReturn.add(scnr.next());// category
        toReturn.add(scnr.next());// type
        toReturn.add(scnr.next());// contest type
        toReturn.add(scnr.next());// pp
        toReturn.add(scnr.next());// base power
        toReturn.add(scnr.next());// accuracy
        Movedex.loadDex(toReturn);
        return toReturn;
    }

    public static void loadMoves(){
        getMoveNames();
    }

    public static Set<String> getMoveNames(){
        return new MovedexParser().getCSV("Game//Movedex.csv");
    }
}
