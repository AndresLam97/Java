package LessonEleven.Animals.LandAnimals;

import LessonEleven.AnimalAbilities.AerialAbilities;
import LessonEleven.AnimalAbilities.AnimalAbilities;
import LessonEleven.AnimalAbilities.LandAbilities;
import LessonEleven.AnimalAbilities.MarineAbilities;

import java.security.SecureRandom;

public class Cat implements AnimalAbilities, LandAbilities, AerialAbilities, MarineAbilities {
    private String name;
    private int speed;
    private final int MAXIMUM_SPEED = 48;

    public Cat() { }

    public Cat(String name) {
        this.name = name;
        this.speed = new SecureRandom().nextInt(MAXIMUM_SPEED + 1);
    }

    @Override
    public boolean flyAble() {
        return false;
    }

    @Override
    public boolean swimAble() {
        return false;
    }

    @Override
    public boolean runAble() {
        return true;
    }

    @Override
    public int move() {
        return this.speed;
    }

    @Override
    public String getInformation() { return "The " + this.name + " is a land animal and has a speed of " + this.speed + " km/h"; }

    @Override
    public String getName() { return this.name; }


}
