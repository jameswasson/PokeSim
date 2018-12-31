package Utils;

import AttackStates.AttackState;
import AttackStates.Move;
import Pokemons.EleType;
import Pokemons.Pokedex;
import Pokemons.Pokemon;
import Pokemons.TypesHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PokedexParser extends CSVParser {

    public List<String> processLine(String line, boolean verbose) {
        List<String> toReturn = new ArrayList<>();
        Scanner scnr = new Scanner(line);
        scnr.useDelimiter(",");
        int no = Integer.valueOf(scnr.next());
        String name = scnr.next();
        EleType type1 = TypesHelper.enumOf(scnr.next());
        EleType type2 = TypesHelper.enumOf(scnr.next());
        int HP = Integer.valueOf(scnr.next());
        int ATK = Integer.valueOf(scnr.next());
        int DEF = Integer.valueOf(scnr.next());
        int SPC = Integer.valueOf(scnr.next());
        int SPD = Integer.valueOf(scnr.next());
        ArrayList<Move> moves = new ArrayList<>();
        while (scnr.hasNext()) {
            String moveName = scnr.next();
            if (!moveName.equals(""))
                moves.add(Move.getMove(moveName));
        }
        if (verbose) {
            System.out.println("No.\t\t" + no);
            System.out.println("Name\t" + name);
            System.out.println("type1\t" + type1);
            System.out.println("type2\t" + type2);
            System.out.println("HP\t\t" + HP);
            System.out.println("ATK\t\t" + ATK);
            System.out.println("DEF\t\t" + DEF);
            System.out.println("SPC\t\t" + SPC);
            System.out.println("SPD\t\t" + SPD);
            for (int i = 0; i < moves.size(); i++)
                System.out.println("move" + i + "\t" + AttackState.getName(moves.get(i).getClass()));
            System.out.println("===========================================");
        }
        Pokemon loadedPokemon = new Pokemon(no,name,type1,type2,HP,ATK,DEF,SPC,SPD,moves, 1);
        Pokedex.loadDex(loadedPokemon);
        return toReturn;
    }

    public static Set<String> loadPokedex() {
        return new PokedexParser().getCSV("Game//Pokedex.csv");
    }

    public static void main(String[] args) {
        Set<String> neededMoves = loadPokedex();
        System.out.println(neededMoves.size());
    }
}
