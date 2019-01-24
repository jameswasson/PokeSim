package AttackStates;

import AttackStates.Moves.NotImplemented;
import AttackStates.Moves.Swift;
import BattleField.IBattleLogger;
import Facade.FacadeFactory;
import Pokemons.EleType;
import Pokemons.Pokemon;

public abstract class AttackState {
    protected static IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);

    //returns appropriate name of move from class
    public static String getName(Class moveClass) {
        String name = "";
        String className = moveClass.getSimpleName();
        String[] separated = className.split("(?=\\p{Upper})");
        for (int i = 0; i < separated.length - 1; i++) {
            name += separated[i] + " ";
        }
        name += separated[separated.length - 1];
        return name;
    }

    //reverse of above function, returns class associated with provided name;
    public static Class<?> getClass(String s) {
        Class<?> dummyClass = Swift.class;
        String BaseDirectory = dummyClass.getName();
        String toRemoveName = dummyClass.getSimpleName();
        String nothing = "";
        String whiteSpace = "\\s+";
        s = s.replaceAll(whiteSpace, nothing);
        BaseDirectory = BaseDirectory.replaceAll(toRemoveName, nothing);
        String classFullName = BaseDirectory + s;
        Class<?> toReturn;
        try {
            toReturn = Class.forName(classFullName);
        } catch (Exception e) {
            e.printStackTrace();
            toReturn = NotImplemented.class;
        }
        return toReturn;
    }

    public abstract void execute(Pokemon ourSelves, Pokemon opponent);

    protected void sayWeUsedMove(Pokemon us) {
        logger.println(us.getName() + " used " + getName(this.getClass()) + "!");
    }

    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        logger.println(getName(this.getClass()) + ".attack() not implemented!");
    }

    abstract DamageCategory getDamageCategory();

    abstract double getCriticalEffect();

    abstract void setCriticalEffect(double effect);

    public abstract EleType getEleType();

    public abstract int getSpeedPriority();

    abstract int getPower();

    abstract protected double getAccuracy(Pokemon ourselves, Pokemon opponent);

    public abstract boolean wasCritical();

    abstract boolean willBeCritical(Pokemon pokemon);
}