package utils;


import battle_field.IBattleLogger;
import facade.FacadeFactory;

import java.util.List;
import java.util.Scanner;

public class Helpers {
    private Helpers(){}

    public static int getNumberFromUserInRange(int lower, int upper, List<Integer> cannotPick) {//range is inclsive
        IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);
        int toReturn = -1;
        do {
            logger.print("Type a number from " + lower + " to " + upper + ": ");
            Scanner scnr = new Scanner(System.in);
            String input = scnr.next();
            try {
                toReturn = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                //empty
            }
            if (toReturn > upper || toReturn < lower) {
                logger.println("Invalid input");
                toReturn = -1;
            } else if (cannotPick.contains(toReturn)) {
                logger.println("Cannot pick selection");
                toReturn = -1;
            }
        } while (toReturn == -1);
        return toReturn;
    }
}
