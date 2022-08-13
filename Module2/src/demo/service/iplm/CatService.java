package demo.service.iplm;

import demo.model.Cat;
import demo.service.ICatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatService extends PetService implements ICatService {
    public static final List<Cat> catList = new ArrayList<>();
    @Override
    public void run() {
        for(Cat cat : catList) {
            double recoded = new Random().nextDouble() * Cat.MAX_SPEED;
            cat.setRecoded(recoded);
        }
    }

    @Override
    public void catchMouse() {

    }

    public void init() {
        catList.add(new Cat("Tom", 1.2));
    }
}
