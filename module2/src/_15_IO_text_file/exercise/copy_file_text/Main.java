package _15_IO_text_file.exercise.copy_file_text;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        String sourceFile = "src/_15_IO_text_file/exercise/copy_file_text/source_file";
        String targetFile = "src/_15_IO_text_file/exercise/copy_file_text/target_file";
        readAndWriteFile.readFile(sourceFile, targetFile);
    }
}
