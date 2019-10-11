package facade;


import battle_field.BattleLog;
import battle_field.IBattleLogger;
import battle_field.TestLog;
import utils.file_manager.FileManager;
import utils.file_manager.IFileManager;
import utils.file_manager.TestFileManager;
import utils.select_move.IChooseMove;
import utils.select_move.TestChooseMove;
import utils.select_move.UserChooseMove;

import java.util.HashMap;
import java.util.Map;

public class FacadeFactory {
    private FacadeFactory() {
    }

    private static Map<Class<?>, Class<?>> interfaceToClass;
    private static Map<Class<?>, Object> interfaceToInstance;

    private static Map<Class<?>, Class<?>> defaultClasses() {
        Map<Class<?>, Class<?>> implMap = new HashMap<>();
        implMap.put(IBattleLogger.class, BattleLog.class);
        implMap.put(IChooseMove.class, UserChooseMove.class);
        implMap.put(IFileManager.class, FileManager.class);
        return implMap;
    }

    private static Map<Class<?>, Class<?>> testClasses() {
        Map<Class<?>, Class<?>> implMap = new HashMap<>();
        implMap.put(IBattleLogger.class, TestLog.class);
        implMap.put(IChooseMove.class, TestChooseMove.class);
        implMap.put(IFileManager.class, TestFileManager.class);
        return implMap;
    }

    /*
     * Returns the instance of specified interface
     * Creates the instance for each time this is first called
     */
    public static <K> K getInstance(Class<K> interfaceKlass) {
        RunCounter.countAsRun();
        if (interfaceToClass == null)
            interfaceToClass = defaultClasses();
        if (interfaceToInstance == null)
            interfaceToInstance = new HashMap<>();

        if (interfaceToInstance.containsKey(interfaceKlass)) {
            return interfaceKlass.cast(interfaceToInstance.get(interfaceKlass));
        }

        try {
            Class<?> klass = interfaceToClass.get(interfaceKlass);
            K obj = interfaceKlass.cast(klass.getDeclaredConstructor().newInstance());
            interfaceToInstance.put(interfaceKlass, obj);
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Invalid Interface");
        }
    }

    public static void createTestingEnvironment() {
        interfaceToClass = testClasses();
    }
}
