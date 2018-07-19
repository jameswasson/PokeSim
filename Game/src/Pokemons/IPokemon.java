package Pokemons;

public interface IPokemon {
    public void selectMove();
    public void selectMove(int indexOfMove);
    public void attack(IPokemon opponent);
    public void runPreBattleStates();
    public void runPostBattleStates();
}
