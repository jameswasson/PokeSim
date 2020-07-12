package attack_states;

import attack_states.moves.Swift;
import battle_field.IBattleLogger;
import facade.FacadeFactory;
import pokemons.EleType;
import pokemons.Pokemon;

public abstract class AttackState {
    protected static IBattleLogger logger = FacadeFactory.getInstance(IBattleLogger.class);

    //returns appropriate name of move from class
    public static String getName(Class moveClass) {
        String className = moveClass.getSimpleName();
        String[] separated = className.split("(?=\\p{Upper})");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < separated.length - 1; i++) {
            sb.append(separated[i]);
            sb.append(" ");
        }
        sb.append(separated[separated.length - 1]);
        return sb.toString();
    }

    //reverse of above function, returns class associated with provided name
    public static Class<? extends Move> getClass(String s) {
        Class<? extends Move> dummyClass = Swift.class;
        String baseDirectory = dummyClass.getName();
        String toRemoveName = dummyClass.getSimpleName();
        String nothing = "";
        String whiteSpace = "\\s+";
        s = s.replaceAll(whiteSpace, nothing);
        baseDirectory = baseDirectory.replaceAll(toRemoveName, nothing);
        String classFullName = baseDirectory + s;
        Class<? extends Move> toReturn;
        try {
            toReturn = Class.forName(classFullName).asSubclass(Move.class);
        } catch (Exception e) {
            throw new RuntimeException("Could not find class with name " + classFullName);
        }
        return toReturn;
    }

    public abstract void execute(Pokemon ourSelves, Pokemon opponent);

    protected void sayWeUsedMove(Pokemon us) {
        logger.println(us.getName() + " used " + getName(this.getClass()) + "!");
    }

    abstract void attack(Pokemon ourselves, Pokemon opponent, int damage);

    abstract DamageCategory getDamageCategory();

    abstract double getCriticalEffect();

    abstract void setCriticalEffect(double effect);

    public abstract EleType getEleType();

    public abstract int getSpeedPriority();

    abstract int getPower();

    protected abstract double getAccuracy(Pokemon ourselves, Pokemon opponent);

    public abstract boolean wasCritical();

    abstract boolean willBeCritical(Pokemon pokemon);
}