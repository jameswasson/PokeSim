package Utils;

import AttackStates.AttackState;
import Pokemons.EleType;
import Pokemons.TypesHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PokedexParser extends CSVParser {

    public List<String> processLine(String line){
        List<String> toReturn = new ArrayList<>();
        Scanner scnr  = new Scanner(line);
        scnr.useDelimiter(",");
        while (scnr.hasNext()){
            int no = Integer.valueOf(scnr.next());
            String name = scnr.next();
            EleType type1 = TypesHelper.enumOf(scnr.next());
            EleType type2 = TypesHelper.enumOf(scnr.next());
            int HP = Integer.valueOf(scnr.next());
            int ATK = Integer.valueOf(scnr.next());
            int DEF = Integer.valueOf(scnr.next());
            int SPC = Integer.valueOf(scnr.next());
            int SPD = Integer.valueOf(scnr.next());
            ArrayList<Class<?>> moves = new ArrayList<>();
            while (scnr.hasNext()) {
                String moveName = scnr.next();
                if (!moveName.equals(""))
                    toReturn.add(moveName);
                    moves.add(AttackState.getClass(moveName));
            }
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
                System.out.println("move" + i + "\t" + AttackState.getName(moves.get(i)));
        }
        System.out.println("===========================================");
        return toReturn;
    }

    public static Set<String> getPokedex(){
        return new PokedexParser().getCSV("Game//Pokedex.csv");
    }

    public static void main(String[] args) {
        Set<String> neededMoves = getPokedex();
        System.out.println(neededMoves.size());
    }
}
