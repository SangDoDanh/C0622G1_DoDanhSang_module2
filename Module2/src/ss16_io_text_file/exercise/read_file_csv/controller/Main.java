package ss16_io_text_file.exercise.read_file_csv.controller;

import ss16_io_text_file.exercise.read_file_csv.model.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        display();
    }

    private static void display() throws IOException {
        List<Country> countryList = readFile("Module2/src/ss16_io_text_file/exercise/read_file_csv/data/country.csv");
        int index = 1;
        for(Country country: countryList) {
            System.out.println(index +","+ country);
            index ++;
        }
    }

    /**
     * đọc file, dữ liệu trả về một ArrayList<Country>
     * @param path đường dẫn file
     * @return trả về một ArrayList<Country>
     * @throws IOException đường dẫn sai,FileNotFoundException
     */
    private static List<Country> readFile(String path) throws IOException {
        File source = new File(path);
        FileReader sourceReader = new FileReader(source);
        BufferedReader bufferedReader = new BufferedReader(sourceReader);
        List<Country> countryList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] countryString = line.split(",");
            Country country = new Country();
            country.setId(countryString[1]);
            country.setName(countryString[2]);
            countryList.add(country);
        }
        return countryList;
    }
}
