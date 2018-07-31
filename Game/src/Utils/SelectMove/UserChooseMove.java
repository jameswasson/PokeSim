package Utils.SelectMove;

import Utils.Helpers;

import java.util.ArrayList;

/**
 * Created by James on 7/6/2018.
 */

public class UserChooseMove implements IChooseMove {
    private ArrayList<Integer> chosenMoves = new ArrayList<>();
    public int getMove(int num_of_moves_available) {

        int choice = Helpers.getNumberFromUserInRange(1,num_of_moves_available);
        chosenMoves.add(choice);
        return choice;
    }

    public int[] getChosenMoves(){
        int[] toReturn = new int[chosenMoves.size()];
        for (int i = 0; i < toReturn.length; i++)
            toReturn[i] = chosenMoves.get(i);
        return toReturn;
    }
}
