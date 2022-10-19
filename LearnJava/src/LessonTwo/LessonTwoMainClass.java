package LessonTwo;

import java.util.Scanner;

public class LessonTwoMainClass {

    // Lab 2.1 and 2.3
     void calculateBMI()
    {
        // Get user inputted height and weight
        System.out.println("Input your height: ");
        float height = new Scanner(System.in).nextFloat();
        System.out.println("Input your weight: ");
        float weight = new Scanner(System.in).nextFloat();

        // Calculate the BMI value
        float BMI = weight / (height * 2);

        // Check the BMI value to output message by conditions
        if(BMI > 0 && BMI <  18.5)
        {
            System.out.println("You are underweight. Please eat more to gain weight");
        }
        else if (BMI >= 18.5 && BMI <= 24.9)
        {
            System.out.println("You have a normal weight. Please keep this diet to stay healthy");
        }
        else if (BMI >= 25 && BMI <= 29.9)
        {
            System.out.println("You are overweight. Please diet to lose weight");
        }
        else if (BMI >= 30)
        {
            System.out.println("You are obesity. Please diet and workout to lose weight");
        }
        else
        {
            // This else condition to output message
            // When user input the negative value in height/weight
            System.out.println("You are input the negative height/weight value. Please retry again");
        }
        return;
    }

    // Lab 2.2
    void checkAddOrEven()
    {
        // Get user inputted number
        System.out.println("Input your number");
        int number = new Scanner(System.in).nextInt();
        if(number % 2 == 0)
        {
            System.out.println("You entered an even number");
        }
        else
        {
            System.out.println("You entered an odd number");
        }
        return;
    }


    public static void main(String[] args) {
        LessonTwoMainClass lessonTwo = new LessonTwoMainClass();

        // Call lab 2.1 and 2.3
        lessonTwo.calculateBMI();

        // Call lab 2.2
        lessonTwo.checkAddOrEven();

    }
}
