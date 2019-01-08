package Utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;

public class Helpers {

    public static int getNumberFromUserInRange(int lower, int upper, List<Integer> cannotPick){//range is inclsive
        IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);
        int toReturn = -1;
        do{
            logger.print("Type a number from " + lower + " to " + upper + ": ");
            Scanner scnr = new Scanner(System.in);
            String input = scnr.next();
            try{
                toReturn = Integer.valueOf(input);
            }catch(NumberFormatException e){}
            if (toReturn > upper || toReturn < lower){
                logger.println("Invalid input");
                toReturn = -1;
            }
            else if (cannotPick.contains(toReturn)){
                logger.println("Cannot pick selection");
                toReturn = -1;
            }
        }while(toReturn == -1);
        return toReturn;
    }

    public static String getFromFile(String file) throws IOException {
        file = "\\" + file;
        try{
            Scanner testScanner = new Scanner(new File(getDirectory()+file));
        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.println("ERROR, File not found at " + getDirectory() + file);
            throw e;
        }
        Scanner scnr = new Scanner(new File(getDirectory()+file));

        StringBuilder contents = new StringBuilder();
        while(scnr.hasNextLine()) {
            contents.append(scnr.nextLine());
            if (scnr.hasNextLine())
                contents.append("\n");
        }
        return contents.toString();
    }

    public static void writeToFile(String data, String file) throws IOException{
        file = "\\" + file;
        PrintWriter out = new PrintWriter(getDirectory() + file);
        out.print(data);
        out.close();
    }

    public static String getDirectory(){
        return new File("").getAbsolutePath();
    }
}
