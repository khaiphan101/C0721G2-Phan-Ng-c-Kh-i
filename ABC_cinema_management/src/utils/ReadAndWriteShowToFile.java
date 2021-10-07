package utils;

import models.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteShowToFile {
    private static String SHOW_FILE = "src\\data\\show_data.csv";
    public static List<Show> readFile() {
        List<Show> list = new ArrayList<>();
        try {
            File file = new File(SHOW_FILE);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] show;
            while ((line = bufferedReaderFile.readLine()) != null) {
                show = line.split(",");
                list.add(new Show(show[0], show[1], show[2], Integer.parseInt(show[3])));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(List<Show> showList) {
        try {
            File file = new File(SHOW_FILE);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Show show : showList) {
                bufferedWriter.write(show.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
