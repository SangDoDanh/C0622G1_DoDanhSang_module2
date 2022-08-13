package demo.service.iplm;

import demo.model.Dog;
import demo.service.IDogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DogService extends PetService implements IDogService {
    public static final List<Dog> dogList = new ArrayList<>();

    @Override
    public void run() {
        for(Dog dog : dogList) {
            double recoded = new Random().nextDouble() * Dog.MAX_SPEED;
            dog.setRecoded(recoded);
        }
    }
    public void init() {
        dogList.add(new Dog("Husky", 5.0));
        dogList.add(new Dog("Bull", 3.0));
    }
}
