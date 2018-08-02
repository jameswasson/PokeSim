package AttackStates;

import AttackStates.Moves.MegaPunch;
import AttackStates.Moves.NotImplemented;
import AttackStates.Moves.Swift;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.EleType;
import Pokemons.Pokemon;
import Utils.RNG;


public class AttackState {
    protected static IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);
    public void execute(Pokemon ourSelves, Pokemon opponent){
        logger.println("Move not implemented");
    }
    protected void sayWeUsedMove(Pokemon us){
        logger.println(us.getName() + " used " + getName(getClass()) + "!");
    }
    public void attack(Pokemon ourselves, Pokemon opponent){
    }
    //returns appropriate name of move from class
    public static String getName(Class moveClass){
        String name = "";
        String className = moveClass.getSimpleName();
        String[] separated = className.split("(?=\\p{Upper})");
        for (int i = 0; i < separated.length - 1; i++){
            name += separated[i] + " ";
        }
        name += separated[separated.length - 1];
        return name;
    }

    //reverse of above function, returns class associated with provided name;
    public static Class<?> getClass (String s){
        Class<?> dummyClass = Swift.class;
        String BaseDirectory = dummyClass.getName();
        String toRemoveName = dummyClass.getSimpleName();
        String nothing = "";
        String whiteSpace = "\\s+";
        s = s.replaceAll(whiteSpace,nothing);
        BaseDirectory = BaseDirectory.replaceAll(toRemoveName,nothing);
        String classFullName = BaseDirectory + s;
        Class<?> toReturn;
        try {
            toReturn = Class.forName(classFullName);
        }
        catch (Exception e){
            toReturn = NotImplemented.class;
        }
        return toReturn;
    }

    @Override
    public String toString(){
        return getName(this.getClass());
    }

    public int getPower(){
        logger.println(toString() + ".getPower not implemented");
        return 0;
    }

    public DamageCategory getDamageCategory(){
        logger.println(toString() + ".getDamageCategory not implemented");
        return DamageCategory.physical;
    }

    public boolean willBeCritical(Pokemon pokemon){
        double baseSpeed = pokemon.getBaseSPD();
        double probabilityOfCrit = (baseSpeed + 76)/ 1024;
        return RNG.random() < probabilityOfCrit;
    }

    public EleType getEleType(){
        //todo implement v
        return EleType.None;
    }
}