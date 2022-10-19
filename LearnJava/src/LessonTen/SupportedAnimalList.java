package LessonTen;

import java.util.HashMap;
import java.util.Map;

public class SupportedAnimalList {

    private static final String[] animalNameList = {"Mouse", "Cat", "Dog", "Tiger", "Lion",
            "Bear", "Pig", "Goat", "Fox",
            "Cow", "Horse", "Rabbit", "Snake",
            "Eagle", "Falcon", "Owl",
            "Delphinus Delphis","Killer Whale", "White Shark"};

    public static Map<String,Integer> getSupportedAnimalList()
    {
        Map<String,Integer> supportedAnimalList = new HashMap<>();
        for(String name : animalNameList)
        {
            supportedAnimalList.put(name,0);
        }
        return supportedAnimalList;
    }
}
