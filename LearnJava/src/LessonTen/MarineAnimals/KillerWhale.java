package LessonTen.MarineAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class KillerWhale extends Animal {

    private final String ANIMAL_TYPE = "marine";
    private final int ANIMAL_DEFAULT_SPEED = 56;

    public KillerWhale(String animalName)
    {
        super(animalName,new SecureRandom().nextInt(57));
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
