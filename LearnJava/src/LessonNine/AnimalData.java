package LessonNine;

import java.util.HashMap;
import java.util.Map;

// All speed data is getting from resource (https://www.google.com)
// With the highest speed of that animal type
public class AnimalData {

    private static final String[] animalNameList = {"Mouse", "Cat", "Dog", "Tiger", "Lion",
            "Bear", "Pig", "Goat", "Fox", "Cow",
            "Horse", "Rabbit", "Eagle", "Falcon", "Owl", "Snake"};

    private static final int[] animalSpeedList = {13, 48, 72, 65, 80,
            56, 18, 16, 68, 40,
            88, 70, 320, 390, 64, 29};

    public static Map<String, Integer> getDefaultAnimalData() {
        Map<String, Integer> animalDataList = new HashMap<>();
        if (animalNameList.length != animalSpeedList.length) {
            System.out.println("Error occur in class AnimalData, function getDefaultAnimalData because the animalNameList and animalSpeedList do not have the same length!");
            System.exit(-1);
        }
        for (int index = 0; index < animalNameList.length; index++) {
            animalDataList.put(animalNameList[index], animalSpeedList[index]);
        }
        return animalDataList;
    }


}
