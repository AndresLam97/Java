package LessonEleven.AnimalAbilities;

import java.util.List;

public interface AnimalAbilities {
    public int move();
    public String getInformation();
    default void setName(String name) { };
    public String getName();
    public List<String> getAbilitiesList();
}
