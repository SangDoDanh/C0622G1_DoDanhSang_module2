package demo.service.iplm;

import demo.model.Cat;
import demo.model.Dog;
import demo.model.Hamster;
import demo.model.Pet;
import demo.service.ICatService;
import demo.service.IDogService;
import demo.service.IHamsterService;
import demo.service.IPetService;

import java.util.ArrayList;
import java.util.List;

public class PetService implements IPetService {
    public static final List<Pet> PETS = new ArrayList<>();
    public static IDogService iDogService = new DogService();
    public static ICatService iCatService = new CatService();
    public static IHamsterService iHamsterService = new HamsterService();
    @Override
    public void init() {
        iDogService.init();
        iCatService.init();
        iHamsterService.init();

        for(Dog dog : DogService.dogList) {
            PETS.add(dog);
        }
        for(Cat cat : CatService.catList) {
            PETS.add(cat);
        }
        for(Hamster hamster : HamsterService.hamsterList) {
            PETS.add(hamster);
        }

    }

    @Override
    public void racing() {
        iDogService.run();
        iCatService.run();
        iHamsterService.run();
    }

    @Override
    public void showRecored() {
        for(Pet pet : PETS) {
            System.out.println(pet);
        }
    }

    @Override
    public void showRecoredBySpeed() {
        for(int i = 0; i < PETS.size() - 1; i++) {
            for(int j = i+ 1; j < PETS.size(); j++) {
                if(PETS.get(i).getRecoded() > PETS.get(j).getRecoded()) {
                    Pet o = PETS.get(i);
                    PETS.set(i, PETS.get(j));
                    PETS.set(j, o);
                }
            }
        }
        showRecored();
    }
}
