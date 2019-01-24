package utils.select_move;

import java.util.List;

public interface IChooseMove {
    public int getMove(int numOfMovesAvailable, List<Integer> noPPMove);

    public int[] getChosenMoves();
}
