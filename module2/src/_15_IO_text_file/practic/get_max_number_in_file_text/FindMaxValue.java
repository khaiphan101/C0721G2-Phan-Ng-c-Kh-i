package _15_IO_text_file.practic.get_max_number_in_file_text;

import java.util.List;

public class FindMaxValue {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src/_15_IO_text_file/practic/get_max_number_in_file_text/number");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/_15_IO_text_file/practic/get_max_number_in_file_text/result", maxValue);
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}
