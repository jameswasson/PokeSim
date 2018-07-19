package Utils.SelectMove;

import Utils.Helpers;

/**
 * Created by James on 7/6/2018.
 */

public class UserChooseMove implements IChooseMove {
    public int getMove(int num_of_moves_available) {
        return Helpers.getNumberFromUserInRange(1,num_of_moves_available);
    }
}
