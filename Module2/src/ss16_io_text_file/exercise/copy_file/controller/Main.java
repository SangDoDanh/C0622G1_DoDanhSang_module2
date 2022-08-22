package ss16_io_text_file.exercise.copy_file.controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        try{
            File source = new File("Module2/src/ss16_io_text_file/exercise/copy_file/data/source.txt");
            File target = new File("Module2/src/ss16_io_text_file/exercise/copy_file/data/new_source.txt");
            Files.copy(source.toPath(), target.toPath());
            countCharacter(target);
        } catch (IOException e) {
            System.out.println("Đường dẫn file lỗi");
        }
    }

    static void countCharacter(File source) {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(source);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                count += line.length();
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Lỗi đường dẫn file rồi");
        }
        System.out.println("số ký tự: " + count);
    }
}
