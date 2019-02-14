package facade;

import utils.file_manager.IFileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class RunCounter {
    private static boolean hasRun = false;
    private RunCounter(){}
    static void countAsRun(){
        if (!hasRun) {
            hasRun = true;

            String filename= "src/facade/Count";
            File countFile = FacadeFactory.getInstance(IFileManager.class).getFile(filename);
            try
            {
                String goodFilePath = countFile.getCanonicalPath();
                FileWriter fw = new FileWriter(goodFilePath,true);
                fw.write("x");//appends the string to the file
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }

        }
    }
}
