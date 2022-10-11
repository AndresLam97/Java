package LessonEleven.AnimalAbilities;

public interface AerialAbilities{
    public boolean flyAble();
    default void setFlyAble(boolean flyAble){};
}
