package LessonEleven.Animals;

import LessonEleven.AnimalAbilities.AerialAbilities;
import LessonEleven.AnimalAbilities.AnimalAbilities;
import LessonEleven.AnimalAbilities.LandAbilities;
import LessonEleven.AnimalAbilities.MarineAbilities;

public class UserDefineAnimal implements AnimalAbilities, AerialAbilities, LandAbilities, MarineAbilities {
    private String name;
    private int speed;
    private boolean runAble, flyAble, swimAble;

    public UserDefineAnimal(){}

    public UserDefineAnimal(String name, int speed, boolean runAble, boolean flyAble, boolean swimAble)
    {
        this.name = name;
        this.speed = speed;
        this.runAble = runAble;
        this.flyAble = flyAble;
        this.swimAble = swimAble;
    }

    @Override
    public boolean flyAble() { return this.flyAble; }

    @Override
    public void setFlyAble(boolean flyAble) { this.flyAble = flyAble; }

    @Override
    public int move() { return this.speed; }

    @Override
    public String getInformation() { return "The " + this.name + " is an user defined animal and has a speed of " + this.speed + " km/h"; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public String getName() { return this.name; }

    @Override
    public boolean runAble() { return runAble; }

    @Override
    public void setRunAble(boolean runAble) { this.runAble = runAble; }

    @Override
    public boolean swimAble() { return this.swimAble; }

    @Override
    public void setSwimAble(boolean swimAble) {
        this.swimAble = swimAble;
    }
}
