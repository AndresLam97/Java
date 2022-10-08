package LessonTen.LandAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class Rabbit extends Animal {
    private String animalName;
    private int animalSpeed;
    private final String ANIMAL_TYPE = "land";
    private final int ANIMAL_DEFAULT_SPEED = 70;

    public Rabbit(String animalName)
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
