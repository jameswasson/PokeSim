package AttackStates;

import AttackStates.Moves.NotImplemented;
import AttackStates.Moves.Swift;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.Pokemon;

public class AttackState {
    protected static IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);
    public void execute(Pokemon ourSelves, Pokemon opponent){
        logger.println("Move not implemented");
    }
    public void sayWeUsedMove(Pokemon us){
        logger.println(us.getName() + " used " + getName(getClass()) + "!");
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
}
