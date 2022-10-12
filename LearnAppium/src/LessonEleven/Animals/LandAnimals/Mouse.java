package LessonEleven.Animals.LandAnimals;

import LessonEleven.AnimalAbility.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Mouse implements AnimalAbilities, LandAbilities, AerialAbilities, MarineAbilities {
    private String name;
    private int speed;
    private int MAXIMUM_SPEED = 13;

    public Mouse() {
    }

    public Mouse(String name) {
        this.name = name;
        this.speed = new SecureRandom().nextInt(MAXIMUM_SPEED + 1);
    }

    @Override
    public boolean flyAble() {
        return false;
    }

    @Override
    public boolean runAble() {
        return true;
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
        return "The " + this.name + " is a land animal and has a speed of " + this.speed + " km/h";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getAbilitiesList() {
        List<String> abilitiesList = new ArrayList<>();
        if (this.flyAble()) {
            abilitiesList.add(ConstantAbilities.FLY_ABLE);
        }
        if (this.runAble()) {
            abilitiesList.add(ConstantAbilities.RUN_ABLE);
        }
        if (this.swimAble()) {
            abilitiesList.add(ConstantAbilities.SWIM_ABLE);
        }
        return abilitiesList;
    }
}
