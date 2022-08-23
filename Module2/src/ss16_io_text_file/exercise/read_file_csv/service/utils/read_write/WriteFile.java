package ss16_io_text_file.exercise.read_file_csv.service.utils.read_write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public static void writeFile(String path, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String line: list) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file");
        }
    }
}
