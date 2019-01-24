package utils.select_move;


import battle_field.IBattleLogger;
import facade.FacadeFactory;

import java.util.List;

public class TestChooseMove implements IChooseMove {
    private int[] listOfMoves;

    public int getMove(int num_of_moves_available, List<Integer> cannotChoose) {
        if (listOfMoves.length == 1)
            return listOfMoves[0];
        int toReturn = listOfMoves[0];
        int[] newList = new int[listOfMoves.length - 1];
        System.arraycopy(listOfMoves, 1, newList, 0, newList.length);
        listOfMoves = newList;
        FacadeFactory.getInstance(IBattleLogger.class).println(Integer.toString(toReturn));
        return toReturn;
    }

    @Override
    public int[] getChosenMoves() {
        return listOfMoves;
    }

    public void loadMoves(int[] loadedMoves) {
        listOfMoves = loadedMoves;
    }
}
