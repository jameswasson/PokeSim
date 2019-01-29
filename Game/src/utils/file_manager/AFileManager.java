package utils.file_manager;

import java.io.File;

abstract class AFileManager implements IFileManager {

    public abstract String getPathExtension();

    public File getFile(String path){
        String fullPath = getPathExtension() + path;
        return checkPath(fullPath);
    }

    private File checkPath(String fileName) {
        File file = new File(fileName);
        if (file.exists())
            return file;
        System.out.println("ERROR! file " + fileName + " does not exist!");
        System.out.println("Current path: " + System.getProperty("user.dir"));
        return null;
    }
}
