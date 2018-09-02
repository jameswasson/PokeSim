package Utils.SelectMove;

import java.util.List;

public interface IChooseMove {
    public int getMove(int num_of_moves_available, List<Integer> noPPMove);
    public int[] getChosenMoves();
}
