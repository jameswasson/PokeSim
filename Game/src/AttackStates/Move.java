package AttackStates;

import AttackStates.Moves.SelfDestruct;
import Pokemons.EleType;
import Pokemons.Movedex;
import Pokemons.Pokemon;
import Pokemons.TypesHelper;

import java.util.List;

public class Move extends AttackState {
    protected EleType type;
    protected DamageCategory damageCategory;
    protected int powerPoints;
    protected int basePower;
    protected int baseAccuracy;
    public Move(){
        List<String> allInfo = Movedex.getMove(getName(this.getClass()));
        type = TypesHelper.enumOf(allInfo.get(1));
        damageCategory = DamageCategory.valueOf(allInfo.get(2).toLowerCase());
        powerPoints = Integer.valueOf(allInfo.get(4));
        baseAccuracy = Integer.valueOf(allInfo.get(5));
        basePower = Integer.valueOf(allInfo.get(6));
    }

    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        sayWeUsedMove(ourSelves);
        attack(ourSelves, opponent);
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent) {
        //todo deal general damage
    }

    public static void main(String[] args) {
        new SelfDestruct();
    }

    @Override
    EleType getEleType() {
        return type;
    }

    @Override
    int getPower() {
        return basePower;
    }
}
