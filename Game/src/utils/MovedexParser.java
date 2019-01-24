package utils;

import facade.FacadeFactory;
import pokemons.Movedex;
import utils.file_manager.IFileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovedexParser extends CSVParser {

    public static void loadMoves() {
        File movedex = FacadeFactory.getInstance(IFileManager.class).getMovedexFile();
        new MovedexParser().getCSV(movedex);
    }

    public void processLine(String line) {
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
        scnr.close();
        Movedex.loadDex(toReturn);
    }
}
