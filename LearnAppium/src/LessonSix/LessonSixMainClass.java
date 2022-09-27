package LessonSix;

import java.util.*;

public class LessonSixMainClass {
    public static void main(String[] args) {
        LessonSixMainClass lessonSix = new LessonSixMainClass();
        lessonSix.initMenu();
    }

    void initMenu() {
        boolean checkValue = true;
        while (checkValue) {
            System.out.println("===== LAB MENU =====");
            System.out.println("1. Lab 6.1.");
            System.out.println("2. Lab 6.2.");
            System.out.println("3. Lab 6.3.");
            System.out.println("4. Lab 6.4.");
            System.out.println("5. Exit program.");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();

            switch (userOption) {
                case 1:
                    Lab61();
                    break;
                case 2:
                    Lab62();
                    break;
                case 3:
                    Lab63();
                    break;
                case 4:
                    Lab64();
                    break;
                case 5:
                    checkValue = false;
                    break;
                default:
                    System.out.println("You entered a number other than 1-5, please retry again");
            }
            System.out.println("");
        }
    }

    public void Lab61() {
        // Declare variables
        String userString;
        String[] detachedList;
        Map<Boolean, String> result = new HashMap<>();

        // Get user input
        System.out.print("Enter your string: ");
        userString = new Scanner(System.in).nextLine();

        // Check string is empty or not
        if (userString.isEmpty()) {
            System.out.println("You entered an empty string. Please retry again!");
            return;
        }

        detachedList = userString.split("[ ]");

        System.out.printf("The total minute(s) is: %d\n", calculateMinutes(detachedList));
    }

    public void Lab62() {
        // Declare variables
        String MY_PASSWORD = "password123";
        int totalEnterTime = 0;

        // Start input and check password flow
        do {
            System.out.print("Enter your password: ");
            String passwordString = new Scanner(System.in).nextLine();
            if (MY_PASSWORD.equals(passwordString)) {
                System.out.println("You entered the correct password. Congratulation!");
                break;
            } else {
                if (totalEnterTime != 2) {
                    System.out.println("You entered the wrong password. Please retry again!");
                    totalEnterTime++;
                } else {
                    System.out.println("You entered incorrect password for 3 times. Please re-run the lab!");
                    totalEnterTime++;
                }
            }
        } while (totalEnterTime < 3);
    }

    public void Lab63() {
        // Declare variables
        String userString;
        String newString = new String("");

        // Get user input
        System.out.print("Enter your string: ");
        userString = new Scanner(System.in).nextLine();

        // Check string are empty or not
        if (userString.equals("")) {
            System.out.println("There is nothing to print because you was entered an empty string!");
            return;
        }

        // Detach digits character in string
        for (char character : userString.toCharArray()) {
            if (Character.isDigit(character)) {
                newString = newString.concat(String.valueOf(character));
            }
        }

        // Display the result string with detached data
        if (newString.equals("")) {
            System.out.println("There is no any digit in your string!");
        } else {
            System.out.println("After detach: " + newString);
        }
    }

    public void Lab64() {
        // Declare variables
        String myUrl;
        Map<Boolean, String> result = new HashMap<>();
        String[] list;

        // Get user input
        System.out.print("Enter your url: ");
        myUrl = new Scanner(System.in).nextLine();

        // Check string is empty or not
        if (myUrl.isEmpty()) {
            System.out.println("You entered an empty url. Please retry again!");
            return;
        }

        // Split url to small parts
        list = myUrl.split("://|/");

        // Check the url data
        result = checkURL(list);
        if (result.containsKey(false)) {
            System.out.println(result.get(false));
            return;
        }

        // Display url information
        displayUrlData(list);

    }

    public static boolean checkDigitString(String string) {
        boolean result = true;
        for (int index = 0; index < string.length(); index++) {
            if (Character.isDigit(string.charAt(index))) {
                continue;
            }
            return false;
        }
        return true;
    }

    public int calculateMinutes(String[] list) {
        int totalMinutes = 0;
        for (int index = 0; index < list.length; index++) {
            switch (list[index].toLowerCase()) {
                case "hrs":
                case "hr":
                case "hour":
                case "hours":
                case "h":
                    if (index == 0) {
                        continue;
                    }
                    if (checkDigitString(list[index - 1])) {
                        totalMinutes += (Integer.parseInt(list[index - 1]) * 60);
                    }
                    break;
                case "min":
                case "minutes":
                case "m":
                case "p":
                    if (index == 0) {
                        continue;
                    }
                    if (checkDigitString(list[index - 1])) {
                        totalMinutes += Integer.parseInt(list[index - 1]);
                    }
                    break;
            }
        }
        return totalMinutes;
    }

    public String getDomainSuffix(String domain) {
        // Split domain to small parts
        String[] detachList = domain.split("[.]");

        // If domain name less than 2
        // Means cannot detach the suffix
        if (detachList.length < 2) {
            return "Error";
        }

        return detachList[detachList.length - 1];
    }

    public Map<Boolean, String> checkURL(String[] list) {
        Map<Boolean, String> result = new HashMap<>();
        // Check protocol
        switch (list[0].toLowerCase()) {
            case "http":
            case "https":
                break;
            default:
                result.put(false, "You have entered an url with incorrect protocol, please retry again!");
                return result;
        }

        // Check domain suffix
        switch (getDomainSuffix(list[1]).toLowerCase()) {
            case "com":
            case "org":
            case "vn":
            case "net":
                break;
            default:
                result.put(false, "You have entered an url with incorrect domain's suffix, please retry again!");
                return result;
        }
        result.put(true, "Correct URL");
        return result;
    }

    public void displayUrlData(String[] list) {
        // If url doesn't have sub path, display the information in the if statement
        // If url have sub path, display the information in the else statement
        if (list.length < 3) {
            System.out.printf("Protocol: %s\n", list[0]);
            System.out.printf("Domain: %s\n", list[1]);
            System.out.printf("Domain suffix: %s\n", getDomainSuffix(list[1]));
        } else {
            System.out.printf("Protocol: %s\n", list[0]);
            System.out.printf("Domain: %s\n", list[1]);
            System.out.printf("Domain suffix: %s\n", getDomainSuffix(list[1]));
            System.out.printf("Domain sub path: ");
            for (int index = 2; index < list.length; index++) {
                System.out.printf("/%s", list[index]);
            }
            System.out.printf("\n");
        }
    }


}
