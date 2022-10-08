package LessonTen.AerialAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class Falcon extends Animal {
    private String animalName;
    private int animalSpeed;
    private final String ANIMAL_TYPE = "aerial";
    private final int ANIMAL_DEFAULT_SPEED = 390;

    public Falcon(String animalName)
    {
        this.animalName = animalName;
        this.animalSpeed = new SecureRandom().nextInt(this.ANIMAL_DEFAULT_SPEED + 1);
    }

    @Override
    public String getName() {
        return this.animalName;
    }

    @Override
    public int getSpeed() {
        return this.animalSpeed;
    }

    @Override
    public String getTYPE() {
        return this.ANIMAL_TYPE;
    }
}
