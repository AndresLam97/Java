package LessonEleven.Animals.AerialAnimals;

import LessonEleven.AnimalAbility.AerialAbilities;
import LessonEleven.AnimalAbility.AnimalAbilities;
import LessonEleven.AnimalAbility.LandAbilities;
import LessonEleven.AnimalAbility.MarineAbilities;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Owl implements AnimalAbilities, LandAbilities, AerialAbilities, MarineAbilities {
    private String name;
    private int speed;
    private final int MAXIMUM_SPEED = 64;

    public Owl() {
    }

    public Owl(String name) {
        this.name = name;
        this.speed = new SecureRandom().nextInt(MAXIMUM_SPEED + 1);
    }

    @Override
    public boolean flyAble() {
        return true;
    }

    @Override
    public boolean swimAble() {
        return false;
    }

    @Override
    public boolean runAble() {
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
        List<String> abilitiesList = new ArrayList<>();
        if(this.flyAble()) {abilitiesList.add("fly");}
        else if (this.runAble()) {abilitiesList.add("run");}
        else if (this.swimAble()) {abilitiesList.add("swim");}
        else { return abilitiesList; }
        return abilitiesList;
    }

}
