package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MovedexParser extends CSVParser {

    public List<String> processLine(String line) {
        List<String> toReturn = new ArrayList<>();
        Scanner scnr = new Scanner(line);
        scnr.useDelimiter(",");
        System.out.println(scnr.next());
        String moveName = scnr.next();
        System.out.println(moveName);
        toReturn.add(moveName);
        System.out.println(scnr.next());
        System.out.println(scnr.next());
        System.out.println(scnr.next());
        System.out.println(scnr.next());
        System.out.println(scnr.next());
        System.out.println(scnr.next());
        return toReturn;
    }

    public static Set<String> getMoveNames(){
        return new MovedexParser().getCSV("Game//Movedex.csv");
    }
}
