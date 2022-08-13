package demo.service.iplm;

import demo.model.Dog;
import demo.model.Hamster;
import demo.service.IDogService;
import demo.service.IHamsterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HamsterService extends PetService implements IHamsterService {
    public static List<Hamster> hamsterList = new ArrayList<>();

    @Override
    public void run() {
        for(Hamster hamster : hamsterList) {
            double recoded = new Random().nextDouble() * Dog.MAX_SPEED;
            hamster.setRecoded(recoded);
        }
    }
    public void init() {
        hamsterList.add(new Hamster("Jerry", 0));
        hamsterList.add(new Hamster("Bull", 0.7));
    }
}
