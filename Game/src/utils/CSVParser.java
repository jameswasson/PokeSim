package utils;


import java.io.File;
import java.util.List;
import java.util.Scanner;

public abstract class CSVParser {

    public abstract void processLine(String line);

    public void getCSV(File file) {
        boolean firstIter = true;
        Scanner scnr;
        try {
            scnr = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(new File("").getAbsolutePath());
            return;
        }
        while (scnr.hasNextLine()) {
            if (!firstIter) {
                processLine(scnr.nextLine());
            } else {
                firstIter = false;
                scnr.nextLine();
            }
        }
        scnr.close();
    }
}
