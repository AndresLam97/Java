package LessonTen;

public class UserDefineAnimal extends Animal{

    private String name;
    private int speed;
    private String type;

    UserDefineAnimal(){};

    UserDefineAnimal(String name,int speed,String type)
    {
        this.name = name;
        this.speed = speed;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String getTYPE() {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
