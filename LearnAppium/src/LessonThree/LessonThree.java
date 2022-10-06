package LessonThree;

import java.util.Scanner;

public class LessonThree {

    int[] initArray()
    {
        int[] integerArray;
        int arrayLength;
        Scanner sc = new Scanner(System.in);

        // Get the length of array entered by user
        System.out.print("Enter the length of array: ");
        arrayLength = sc.nextInt();
        integerArray = new int[arrayLength];

        // Set the value of array elements by user input
        for(int i = 0; i < integerArray.length; i++)
        {
            System.out.printf("Enter the value of element %d: ", (i+1));
            integerArray[i] = sc.nextInt();
        }
        return integerArray;
    }

    void displayArray(int[] integerArray)
    {
        // Display the array values entered by user
        System.out.print("The values of array are: ");
        for (int i = 0; i < integerArray.length; i++) {
            System.out.printf("%d ",integerArray[i]);
        }
        System.out.println();
    }

    void findOddAndEvenNumber(int[] integerArray)
    {
        int totalOddNumber = 0;
        int totalEvenNumber = 0;
        for(int i = 0; i < integerArray.length;i++)
        {
            if(integerArray[i] % 2 == 1) { totalOddNumber++;}
            else { totalEvenNumber++;}
        }
        System.out.printf("Total of odd numbers in the array is %d. \n",totalOddNumber);
        System.out.printf("Total of even numbers in the array is %d.\n",totalEvenNumber);
    }

    void findMaxAndMinNumber(int[] integerArray)
    {
        int maxNumber = integerArray[0];
        int minNumber = integerArray[0];
        for (int i = 0; i < integerArray.length; i++) {
            if(maxNumber < integerArray[i]) { maxNumber = integerArray[i];}
            if(minNumber > integerArray[i]) { minNumber = integerArray[i];}
        }
        System.out.printf("The maximum number in array is %d. \n", maxNumber);
        System.out.printf("The minimum number in array is %d. \n", minNumber);
    }

    void sortArray(int[] integerArray)
    {
        for(int i = 0 ; i < integerArray.length;i++)
        {
            for(int j = i; j < integerArray.length; j++)
            {
                if(integerArray[i] > integerArray[j])
                {
                    int temp = integerArray[i];
                    integerArray[i] = integerArray[j];
                    integerArray[j] = temp;
                }
            }
        }
    }

    // Solution 1 for lab 3.4
    int[] mergeTwoSortedArray(int[] integerArray1, int[] integerArray2)
    {
        int TOTAL_LENGTH_OF_TWO_ARRAYS = integerArray1.length + integerArray2.length;
        int[] newArray = new int[TOTAL_LENGTH_OF_TWO_ARRAYS];
        int keyIndexOfArray1 = 0;
        int keyIndexOfArray2 = 0;

        for(int i = 0 ; i < newArray.length; i++)
        {
            if(integerArray1[keyIndexOfArray1] < integerArray2[keyIndexOfArray2])
            {
                newArray[i] = integerArray1[keyIndexOfArray1];
                if(keyIndexOfArray1 == integerArray1.length - 1) {continue;}
                else { keyIndexOfArray1++;}
            }
            else
            {
                newArray[i] = integerArray2[keyIndexOfArray2];
                if(keyIndexOfArray2 == integerArray2.length - 1) {continue;}
                else { keyIndexOfArray2++;}
            }
        }
        return newArray;
    }

    // Solution 2 for lab 3.4
    int[] mergeTwoSortedArray2(int[] integerArray1, int[] integerArray2)
    {
        int TOTAL_LENGTH_OF_TWO_ARRAYS = integerArray1.length + integerArray2.length;
        int[] newArray = new int[TOTAL_LENGTH_OF_TWO_ARRAYS];

        for(int i = 0; i < integerArray1.length;i++)
        {
            newArray[i] = integerArray1[i];
        }

        for(int i = 0 ; i < integerArray2.length; i++)
        {
            newArray[integerArray1.length + i] = integerArray2[i];
        }

        sortArray(newArray);

        return newArray;
    }


    public static void main(String[] args) {
        LessonThree lessonThree = new LessonThree();
        int[] integerArray;
        int[] integerArray2;
        int[] mergeWithTwoSortedArray;

        // Init array (include elements value)
        integerArray = lessonThree.initArray();

        // Display the array values entered by user
        lessonThree.displayArray(integerArray);

        // Lab 3.1
        System.out.println("\n----- This is lab 3.1 -----");
        lessonThree.findOddAndEvenNumber(integerArray);

        // Lab 3.2
        System.out.println("\n----- This is lab 3.2 -----");
        lessonThree.findMaxAndMinNumber(integerArray);

        // Lab 3.3
        System.out.println("\n----- This is lab 3.3 -----");
        System.out.println("Before sort:");
        lessonThree.displayArray(integerArray);
        lessonThree.sortArray(integerArray);
        System.out.println("After sort:");
        lessonThree.displayArray(integerArray);

        // Lab 3.4
        System.out.println("\n----- This is lab 3.4 -----");
        integerArray2 = lessonThree.initArray();
        lessonThree.displayArray(integerArray2);
        lessonThree.sortArray(integerArray2);
        System.out.println("After sort:");
        lessonThree.displayArray(integerArray2);

        mergeWithTwoSortedArray = lessonThree.mergeTwoSortedArray2(integerArray,integerArray2);

        System.out.println();
        System.out.print("Two arrays after merge: ");
        lessonThree.displayArray(mergeWithTwoSortedArray);
    }
}
