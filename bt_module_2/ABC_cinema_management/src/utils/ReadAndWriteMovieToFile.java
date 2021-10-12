package utils;

import models.Movie;
import models.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteMovieToFile {
    private static String MOVIE_FILE = "src\\data\\movie_data.csv";

    public static List<Movie> readFile() {
        List<Movie> list = new ArrayList<>();
        try {
            File file = new File(MOVIE_FILE);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReaderFile.readLine()) != null) {
                list.add(new Movie(line));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("Movie File: File not found or failure document!");
//                e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(List<Movie> movieList) {
        try {
            File file = new File(MOVIE_FILE);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Movie movie : movieList) {
                bufferedWriter.write(movie.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
