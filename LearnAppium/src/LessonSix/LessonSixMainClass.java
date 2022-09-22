package LessonSix;

import javax.xml.stream.events.Characters;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LessonSixMainClass {
    public static void main(String[] args) {
        LessonSixMainClass lessonSix = new LessonSixMainClass();
        lessonSix.initMenu();
    }

    void initMenu()
    {
        boolean checkValue = true;
        while(checkValue)
        {
            System.out.println("===== LAB MENU =====");
            System.out.println("1. Lab 6.1.");
            System.out.println("2. Lab 6.2.");
            System.out.println("3. Lab 6.3.");
            System.out.println("4. Lab 6.4.");
            System.out.println("5. Exit program.");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();

            switch(userOption)
            {
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

    public void Lab61(){}

    public void Lab62(){
        String MY_PASSWORD = "password123";
        int totalEnterTime = 0;
        do {
            System.out.print("Enter your password: ");
            String passwordString = new Scanner(System.in).nextLine();
            if(MY_PASSWORD.equals(passwordString))
            {
                System.out.println("You entered the correct password. Congratulation!");
                break;
            }
            else
            {
                if(totalEnterTime != 2){
                System.out.println("You entered the wrong password. Please try again!");
                totalEnterTime++;}
                else{
                    System.out.println("You entered incorrect password for 3 times. Please re-run the lab!");
                    totalEnterTime++;
                }
            }
        }while (totalEnterTime < 3);
    }

    public void Lab63(){
        System.out.print("Enter your string: ");
        String userString = new Scanner(System.in).nextLine();
        String newString = new String("");
        for(char character : userString.toCharArray())
        {
            if(Character.isDigit(character))
            {
                newString = newString.concat(String.valueOf(character));
            }
        }
        if(userString.equals(""))
        {
            System.out.println("There is nothing to print because you was entered an empty string!");
        }
        else if(newString.equals(""))
        {
            System.out.println("There is no any digit in your string!");
        }
        else
        {
            System.out.println("After detach: " + newString);
        }
    }

    public void Lab64()
    {
        System.out.print("Enter your url: ");
        String myUrl = new Scanner(System.in).nextLine();
        String[] list = myUrl.split("://|/");
        for(int index = 0 ; index < list.length; index++)
        {
            System.out.println(list[index]);
        }
    }

    boolean checkUrl(String[] url)
    {
        boolean protocolKey = false;
        boolean domainExtensionKey = false;
        String
        switch(url[0].toLowerCase())
        {
            case "http": protocolKey = true;
            break;
            case "https": protocolKey = true;
            break;
            default: protocolKey = false;
        }

    }




}
