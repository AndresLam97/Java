package LessonEleven.Animals.AerialAnimals;

import LessonEleven.AnimalAbilities.AerialAbilities;
import LessonEleven.AnimalAbilities.AnimalAbilities;
import LessonEleven.AnimalAbilities.LandAbilities;
import LessonEleven.AnimalAbilities.MarineAbilities;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eagle implements AnimalAbilities, LandAbilities, AerialAbilities, MarineAbilities {
    private String name;
    private int speed;
    private final int MAXIMUM_SPEED = 320;

    public Eagle() {
    }

    public Eagle(String name) {
        this.name = name;
        this.speed = new SecureRandom().nextInt(MAXIMUM_SPEED + 1);
    }

    @Override
    public boolean flyAble() {
        return true;
    }

    @Override
    public boolean runAble() {
        return false;
    }

    @Override
    public boolean swimAble() {
        return false;
    }

    @Override
    public int move() {
        return this.speed;
    }

    @Override
    public String getInformation() {
        return "The " + this.name + " is a aerial animal and has a speed of " + this.speed + " km/h";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getAbilitiesList() {
        List<String> abilitiesList = new ArrayList<>(Arrays.asList("fly"));
        return abilitiesList;
    }
}
