package LessonEight;

public class Animal {
    private String animalName;
    private int speed;

    public Animal() {
    }

    public Animal(int speed) {
        this.speed = speed;
    }

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public Animal(String animalName, int speed) {
        this.animalName = animalName;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
