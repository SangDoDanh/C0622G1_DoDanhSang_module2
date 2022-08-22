package demo_file;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Module2/src/demo_file/data.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
