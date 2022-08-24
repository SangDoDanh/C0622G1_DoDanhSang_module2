package ss17_binary_file.exercise.copy_file.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MainController {
    public static void main(String[] args) {
        final String PATH_SOURCE = "Module2/src/ss17_binary_file/exercise/copy_file/data/source.txt";
        final String PATH_TARGET = "Module2/src/ss17_binary_file/exercise/copy_file/data/source1.txt";

        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        try{
            fileInputStream= new FileInputStream(PATH_SOURCE);
            fileOutputStream = new FileOutputStream(PATH_TARGET);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            System.out.println("Số byte trong tệp: " + fileOutputStream.getChannel().size());
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        File io = new File(PATH_SOURCE);
//        File os = new File(PATH_TARGET);
//        try {
//            Files.copy(io.toPath(), os.toPath(),StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("byte in target file: " + os.length());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
