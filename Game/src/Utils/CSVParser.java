package Utils;

import java.io.File;
import java.util.*;

public abstract class CSVParser {

    public abstract List<String> processLine(String line, boolean verbose);

    public Set<String> getCSV(File file){
        Set<String> toReturn = new HashSet<>();
        boolean firstIter = true;
        Scanner scnr;
        try {
            scnr = new Scanner(file);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(new File("").getAbsolutePath());
            return null;
        }
        while(scnr.hasNextLine()){
            if (!firstIter) {
                List<String> processed = processLine(scnr.nextLine(),false);
                toReturn.addAll(processed);
            }
            else {
                firstIter = false;
                scnr.nextLine();
            }
        }
        scnr.close();
        return toReturn;
    }


}
