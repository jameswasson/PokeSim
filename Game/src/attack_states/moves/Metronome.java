package attack_states.moves;

import attack_states.Move;
import pokemons.Pokemon;
import utils.RNG;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Metronome extends Move {
    private static List<Class> availableMoves;

    private static List<Class> getMoves() {
        if (availableMoves == null)
            availableMoves = findMoves();
        return availableMoves;
    }

    private static Class getRandomMove() {
        return getMoves().get(RNG.randomInt(0, getMoves().size() - 1));
    }

    private static List<Class> findMoves() {
        String moveHeadder = Metronome.class.getName().replaceAll(Metronome.class.getSimpleName(), "");
        File folder = new File("Game/src/AttackStates/Moves");//todo make file_manager handle this
        List<String> pickableMoveNames = new ArrayList<>();
        List<Class> pickableMoveClasses = new ArrayList<>();
        File[] listOfFiles = folder.listFiles();

        for (File curFile : listOfFiles)
            if (curFile.isFile()) {
                if (curFile.getName().contains(".java")) {
                    if (!curFile.getName().contains("Struggle") && !curFile.getName().contains("Metronome"))
                        pickableMoveNames.add(moveHeadder + curFile.getName().replace(".java", ""));
                }
            }

        try {
            for (String s : pickableMoveNames)
                pickableMoveClasses.add(Class.forName(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pickableMoveClasses;
    }

    @Override
    public void attack(Pokemon ourselves, Pokemon opponent, int damage) {
        ourselves.setAttackState(getRandomMove());
        ourselves.attack(opponent);
    }

    @Override
    public boolean willBeCritical(Pokemon pokemon) {
        return false;
    }
}
