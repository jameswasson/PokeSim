package utils;

import facade.FacadeFactory;
import pokemons.Pokedex;
import utils.file_manager.IFileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokedexParser extends CSVParser {

    public static void loadPokedex() {
        File pokedexFile = FacadeFactory.getInstance(IFileManager.class).getFile("Pokedex.csv");
        new PokedexParser().getCSV(pokedexFile);
    }

    public void processLine(String line) {
        List<String> toReturn = new ArrayList<>();
        Scanner scnr = new Scanner(line);
        scnr.useDelimiter(",");

        toReturn.add(scnr.next());
        String name = scnr.next();
        toReturn.add(scnr.next());
        toReturn.add(scnr.next());
        toReturn.add(scnr.next());
        toReturn.add(scnr.next());
        toReturn.add(scnr.next());
        toReturn.add(scnr.next());
        toReturn.add(scnr.next());
        while (scnr.hasNext()) {
            String moveName = scnr.next();
            if (!moveName.equals(""))
                toReturn.add(moveName);
        }
        scnr.close();

        Pokedex.addPokemon(name, toReturn);
    }
}
