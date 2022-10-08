package LessonTen.AerialAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class Falcon extends Animal {

    private final String ANIMAL_TYPE = "aerial";


    public Falcon(String animalName)
    {
        super(animalName,new SecureRandom().nextInt(391));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String getTYPE() {
        return this.ANIMAL_TYPE;
    }
}
