package LessonTen;

import java.util.Map;

public abstract class Animal {

    protected String name;
    protected int speed;

    public Animal() {
    }

    public Animal(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public abstract String getName();

    public abstract int getSpeed();

    public abstract String getTYPE();

    public String toString() {
        return "The " + getName() + " is an " + getTYPE() + " animal and has a speed of " + getSpeed() + " km/h";
    }
}
