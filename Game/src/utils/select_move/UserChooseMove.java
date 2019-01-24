package utils.select_move;

import utils.Helpers;

import java.util.ArrayList;
import java.util.List;

public class UserChooseMove implements IChooseMove {
    private ArrayList<Integer> chosenMoves = new ArrayList<>();

    public int getMove(int numOfMovesAvailable, List<Integer> noPPMove) {

        int choice = Helpers.getNumberFromUserInRange(1, numOfMovesAvailable, noPPMove);
        chosenMoves.add(choice);
        return choice;
    }

    public int[] getChosenMoves() {
        int[] toReturn = new int[chosenMoves.size()];
        for (int i = 0; i < toReturn.length; i++)
            toReturn[i] = chosenMoves.get(i);
        return toReturn;
    }
}
