package LessonEleven.AnimalAbilities;

public interface MarineAbilities {
    public boolean swimAble();
    default void setSwimAble(boolean swimAble){};
}
