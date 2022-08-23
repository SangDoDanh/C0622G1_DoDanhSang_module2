package ss16_io_text_file.exercise.read_file_csv.service.impl;

import ss16_io_text_file.exercise.read_file_csv.model.Country;
import ss16_io_text_file.exercise.read_file_csv.service.ICountryService;
import ss16_io_text_file.exercise.read_file_csv.service.utils.read_write.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class CountryService implements ICountryService {
    private final String PATH_COUNTRY = "Module2/src/ss16_io_text_file/exercise/read_file_csv/service/data/country.csv";
    private static List<Country> countryList;

    /**
     *Hiển thị danh sách Country
     */
    @Override
    public void display() {
        countryList = readFileCountry(PATH_COUNTRY);
        for(Country country : countryList) {
            System.out.println(country);
        }
    }

    /**
     * Đọc dữ liệu trong file và trả về một List<Country>
     * @param path đường dẫn file
     * @return List<Country>
     */
    private List<Country> readFileCountry(String path) {
        List<String> countryString =  ReadFile.readFile(PATH_COUNTRY);
        List<Country> countryList = new ArrayList<>();
        String[] propertyOfCountry;
        for(String c : countryString) {
            propertyOfCountry = c.split(",");
            countryList.add(new Country(propertyOfCountry[1], propertyOfCountry[2]));
        }
        return countryList;
    }

}
