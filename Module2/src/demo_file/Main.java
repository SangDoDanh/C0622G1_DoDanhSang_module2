package demo_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        List<Dog> dogs = readFileDog("Module2/src/demo_file/dog.txt");
        for(Dog dog : dogs) {
            System.out.println(dog);
        }
    }

    static List<Dog> readFileDog (String path) {
        List<Dog> dogList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] propertyOfDog;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                propertyOfDog = line.split(",");
                dogList.add(new Dog(Integer.parseInt(propertyOfDog[0]), propertyOfDog[1]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Mi ngao ah, sai duong dan kia!");
        } catch (IOException e) {
            System.out.println("Mi lai ngao roi, noi dung sai");
        }
        return dogList;
    }

}
