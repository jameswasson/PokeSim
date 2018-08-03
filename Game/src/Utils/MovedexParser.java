package Utils;

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
        String moveName = scnr.next();
        toReturn.add(moveName);
        System.out.println(moveName);
        String category = scnr.next();
        String type = scnr.next();
        String contest_type = scnr.next();
        String pp = scnr.next();
        String basepow = scnr.next();
        String accuracy = scnr.next();
        return toReturn;
    }

    public static Set<String> getMoveNames(){
        return new MovedexParser().getCSV("Game//Movedex.csv");
    }
}
