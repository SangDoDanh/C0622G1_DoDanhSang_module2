package demo.controller;

import demo.service.IPetService;
import demo.service.iplm.PetService;

public class MainController {

    public static final IPetService I_PET_SERVICE = new PetService();
    public void racing() {
        I_PET_SERVICE.init();
        I_PET_SERVICE.racing();
        I_PET_SERVICE.showRecored();
        I_PET_SERVICE.showRecoredBySpeed();
    }
}
