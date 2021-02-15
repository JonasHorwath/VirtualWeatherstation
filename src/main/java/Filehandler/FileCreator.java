package Filehandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCreator {

    public static void writeToTextFile(List<String> list, String fileName) throws IOException {

        File file = new File("src/main/Data/" + fileName + ".txt");

        FileWriter fileWriter = new FileWriter(file);

        for (String line:
             list) {
            fileWriter.write(line + "\n");
        }

        fileWriter.close();

    }

}
