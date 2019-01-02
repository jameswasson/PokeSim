package Utils.FileManager;

import java.io.File;

abstract class AFileManager implements IFileManager {
    public String POKEDEX_PATH;
    public String MOVEDEX_PATH;

    protected abstract void setPaths();

    public File getPokedexFile() {
        setPaths();
        return checkPath(POKEDEX_PATH);
    }

    public File getMovedexFile() {
        setPaths();
        return new File(MOVEDEX_PATH);
    }

    public File checkPath(String fileName){
        File file = new File(fileName);
        if (file.exists())
            return file;
        System.out.println("ERROR! file " + fileName + " does not exist!");
        System.out.println("Current path: " + System.getProperty("user.dir"));
        return null;
    }
}
