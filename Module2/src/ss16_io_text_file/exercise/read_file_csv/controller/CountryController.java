package ss16_io_text_file.exercise.read_file_csv.controller;

import ss16_io_text_file.exercise.read_file_csv.service.ICountryService;
import ss16_io_text_file.exercise.read_file_csv.service.impl.CountryService;

public class CountryController {
    private ICountryService iCountryService= new CountryService();

    public void start() {
        iCountryService.display();
    }
}
