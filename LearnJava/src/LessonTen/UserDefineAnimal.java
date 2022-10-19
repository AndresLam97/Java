package LessonTen;

public class UserDefineAnimal extends Animal{

    private String type;

    UserDefineAnimal(){};

    UserDefineAnimal(String name,int speed,String type)
    {
        super(name,speed);
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
