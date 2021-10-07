package ultis;

import models.Brand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBrandsToFile {
    private static String BRAND_FILE = "src\\data\\brand_file.csv";

    public static List<Brand> readFile() {
        List<Brand> list = new ArrayList<>();
        try {
            File file = new File(BRAND_FILE);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] brand;
            while ((line = bufferedReaderFile.readLine()) != null) {
                brand = line.split(",");
                list.add(new Brand(brand[0],brand[1],brand[2]));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
        }
        return list;
    }

    public static void writeFile(List<Brand> movieList) {
        try {
            File file = new File(BRAND_FILE);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Brand brand : movieList) {
                bufferedWriter.write(brand.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
