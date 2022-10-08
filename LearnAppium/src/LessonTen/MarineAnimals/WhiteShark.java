package LessonTen.MarineAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class WhiteShark extends Animal {

    private final String ANIMAL_TYPE = "marine";

    public WhiteShark(String animalName)
    {
        super(animalName,new SecureRandom().nextInt(57));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getTYPE() {
        return this.ANIMAL_TYPE;
    }
}
