package Utils;

import Facade.FacadeFactory;
import Pokemons.Pokedex;
import Utils.FileManager.IFileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokedexParser extends CSVParser {

    public List<String> processLine(String line) {
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

        Pokedex.addPokemon(name, toReturn);
        return new ArrayList<>();
    }

    public static void loadPokedex() {
        File pokedexFile = FacadeFactory.getInstance(IFileManager.class).getPokedexFile();
        new PokedexParser().getCSV(pokedexFile);
    }
}
