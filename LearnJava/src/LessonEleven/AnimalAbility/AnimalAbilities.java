package LessonEleven.AnimalAbility;

import java.util.List;

public interface AnimalAbilities {
    // Public method
    public int move();
    public String getInformation();
    public String getName();
    public List<String> getAbilitiesList();

    // Default method
    default void setName(String name) { };

}
