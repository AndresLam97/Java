package LessonNine;

// Outer Class
public class Animal {
    private final String name;
    private final int speed;
    private final boolean flyAble;

    public Animal(AnimalBuilder animal)
    {
        this.name = animal.name;
        this.speed = animal.speed;
        this.flyAble = animal.flyAble;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isFlyAble() {
        return flyAble;
    }

    public String toString()
    {
        if(this.flyAble){
            return this.name + " with speed " + this.speed + "km/h is fly able.";
        }
        else
        {
            return this.name + " with speed " + this.speed + "km/h is not fly able.";
        }
    }
    // Inner Class
    public static class AnimalBuilder
    {
        private String name;
        private int speed;
        private boolean flyAble;

        public AnimalBuilder() {
        }

        public AnimalBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        public AnimalBuilder setSpeed(int speed)
        {
            this.speed = speed;
            return this;
        }

        public AnimalBuilder setFlyAble(boolean flyAble)
        {
            this.flyAble = flyAble;
            return this;
        }

        public Animal toAnimal()
        {
            return new Animal(this);
        }
    }

}
