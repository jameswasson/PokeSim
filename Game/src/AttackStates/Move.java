package AttackStates;

import Pokemons.Pokemon;

public class Move extends AttackState {
    @Override
    public void execute(Pokemon ourSelves, Pokemon opponent) {
        sayWeUsedMove(ourSelves);
        attack(ourSelves, opponent);
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent) {
        //todo deal general damage
    }
}
