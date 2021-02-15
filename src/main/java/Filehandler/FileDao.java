package Filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDao {

    String fileName;
    ArrayList<String> data = new ArrayList<>();

    public FileDao(String fileName) {
        this.fileName = fileName;
    }

    public void readData() throws FileNotFoundException {

        File file = new File(fileName);
        Scanner mySc = new Scanner(file);
        do {
            data.add(mySc.nextLine());
        } while (mySc.hasNextLine());

    }

    public ArrayList<String> getData() {
        return data;
    }

}
