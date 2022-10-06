package LessonTen;

public abstract class Animal {

    public abstract String getName();

    public abstract int getSpeed();

    public abstract String getTYPE();

    public String toString()
    {
        return "The " + getName() + " is an " + getTYPE() + " animal and has a speed of " + getSpeed() + " km/h";
    }
}
