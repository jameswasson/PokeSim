package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;

public class RazorLeaf extends Move {
    public boolean willBeCritical(Pokemon pokemon){
        return new Crabhammer().willBeCritical(pokemon);
    }
}
