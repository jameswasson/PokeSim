package AttackStates.Moves;

import AttackStates.Move;
import Pokemons.Pokemon;
import Utils.RNG;

public class Crabhammer extends Move {
    public boolean willBeCritical(Pokemon pokemon){
        double baseSpeed = pokemon.getBaseSPD();
        double probabilityOfCrit = (baseSpeed + 76)/ 128;
        wasCritical = RNG.random() < probabilityOfCrit;
        return wasCritical;
    }
}
