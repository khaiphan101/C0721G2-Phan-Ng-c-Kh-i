package _15_IO_text_file.exercise.read_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
    public ArrayList<Country> readFile(String filePath) {
        ArrayList<Country> countriesList = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] country;
            while ((line = bufferedReaderFile.readLine()) != null) {
                country = line.split(",");
                countriesList.add(new Country(Integer.parseInt(country[0]), country[1], country[2]));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
        }
        return countriesList;
    }
}
