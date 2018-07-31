package Facade;

import java.util.HashMap;
import java.util.Map;

import BattleField.BattleLog;
import BattleField.IBattleLogger;
import BattleField.TestLog;
import BattleField.TestMakerLog;
import Utils.SelectMove.IChooseMove;
import Utils.SelectMove.TestChooseMove;
import Utils.SelectMove.UserChooseMove;

public class FacadeFactory {
    private static Map<Class<?>, Class<?>> defaultClasses() {
        Map<Class<?>, Class<?>> implMap = new HashMap<>();
        implMap.put(IBattleLogger.class, BattleLog.class);
        implMap.put(IChooseMove.class, UserChooseMove.class);
        return implMap;
    }
    private static Map<Class<?>, Class<?>> testClasses(){
        Map<Class<?>, Class<?>> implMap = new HashMap<>();
        implMap.put(IBattleLogger.class, TestLog.class);
        implMap.put(IChooseMove.class, TestChooseMove.class);
        return implMap;
    }
    private static Map<Class<?>, Class<?>> testMakerClasses(){
        Map<Class<?>, Class<?>> implMap = new HashMap<>();
        implMap.put(IBattleLogger.class, TestMakerLog.class);
        implMap.put(IChooseMove.class, UserChooseMove.class);
        return implMap;
    }
    private static Map<Class<?>, Object> defaultInstances() {
        return new HashMap<>();
    }

    private static Map<Class<?>, Class<?>> interfaceToClass;
    private static Map<Class<?>, Object> interfaceToInstance;

    /*
     * Returns the instance of specified interface
     * Creates the instance for each time this is first called
     */
    private static <K> K _getInstance(Class<K> intf) {
        Class klass = interfaceToClass.get(intf);

        if(klass == null)
            return null;

        K obj = null;
        if(interfaceToInstance.containsKey(intf)){
            obj = (K)interfaceToInstance.get(intf);
        }

        if(obj == null) {
            try {
                obj = (K)klass.newInstance();
                interfaceToInstance.put(intf,obj);
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access instance of " + klass.getCanonicalName());
                e.printStackTrace();
            } catch (InstantiationException e) {
                System.out.println("Cannot make instance of " + klass.getCanonicalName());
                e.printStackTrace();
            }
        }
        if(obj != null) {
            if(!klass.isInstance(obj)){
                interfaceToInstance.put(intf,null);
                return _getInstance(intf);
            }
        }
        return obj;
    }
    public static <K> K getInstance(Class<K> intf) {
        if (interfaceToClass == null)
            interfaceToClass = defaultClasses();
        if (interfaceToInstance == null)
            interfaceToInstance = defaultInstances();
        return _getInstance(intf);
    }
    public static void createTestingEnvironment(){
        interfaceToClass = testClasses();
    }
    public static void createTestMakerEnvironment(){
        interfaceToClass = testMakerClasses();
    }

    public int eh(){
        return 0;
    }
}
