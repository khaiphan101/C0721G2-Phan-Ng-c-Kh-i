package ultis;


import models.LimitShortTerm;
import models.LongTerm;

import models.Passbook;

import models.UnlimitShortTerm;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWritePassbookToFile {
    private static final String LONG_TERM_FILE = "src\\data\\long_term_file.csv";
    private static final String SHORT_TERM_FILE = "src\\data\\short_term_file.csv";
    public static List<Passbook> readFile(String filePath) {
        List<Passbook> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line;
            String[] passbook;
            while ((line = bufferedReaderFile.readLine()) != null) {
                passbook = line.split(",");
                if (filePath.equals(LONG_TERM_FILE)) {
                    list.add(new LongTerm(passbook[0], passbook[1], passbook[2], passbook[3], passbook[4],passbook[5], passbook[6], passbook[7]));
                } else if (filePath.equals(SHORT_TERM_FILE)) {
                    if(passbook.length == 6){
                        list.add(new UnlimitShortTerm(passbook[0], passbook[1], passbook[2], passbook[3], passbook[4], passbook[5]));
                    }else {
                        list.add(new LimitShortTerm(passbook[0], passbook[1], passbook[2], passbook[3], passbook[4], passbook[5], passbook[6]));
                    }
                }
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("Lỗi file không có hoặc nhập dữ liệu lỗi!");
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(List<Passbook> vehicleList, String filePath) {
        try {
            File file = new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Passbook passbook : vehicleList) {
                bufferedWriter.write(passbook.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
