package LessonEleven.RacingFeatureController;

import java.util.HashMap;
import java.util.Map;

public class AnimalGeneralInformation {

    private static final String[] animalNameList = {"Mouse", "Cat", "Dog", "Tiger", "Lion",
            "Bear", "Pig", "Goat", "Fox",
            "Cow", "Horse", "Rabbit", "Snake",
            "Eagle", "Falcon", "Owl",
            "Delphinus Delphis","Killer Whale", "White Shark"};

    public static int RUN_ABLE = 1;
    public static int FLY_ABLE = 2;
    public static int SWIM_ABLE = 3;
    public static int RUN_FLY_ABLE = 4;
    public static int RUN_SWIM_ABLE = 5;
    public static int FLY_SWIM_ABLE = 6;
    public static int ALL = 7;

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
