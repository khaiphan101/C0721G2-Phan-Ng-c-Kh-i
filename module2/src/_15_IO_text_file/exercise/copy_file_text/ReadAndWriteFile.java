package _15_IO_text_file.exercise.copy_file_text;

import java.io.*;

public class ReadAndWriteFile {
    public void readFile(String inputFile, String outputFile) {
        try {
            File inFile = new File(inputFile);
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println("completed copy file");
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
        }
    }
}
