package LessonThirteen.ApplicationWithoutUI;

import LessonThirteen.ApplicationWithoutUI.Utilities.ApplicationWithoutUIView;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        boolean keyValue = true;
        ApplicationWithoutUIView applicationWithoutUIView = new ApplicationWithoutUIView();
        while (keyValue) {
            System.out.println("======= Book Management Program (CRUD)============");
            System.out.println("1. New book.");
            System.out.println("2. Find a book(ISBN).");
            System.out.println("3. Update a book.");
            System.out.println("4. Delete a book.");
            System.out.println("5. Print the book list.");
            System.out.println("0. Exit.");
            System.out.print("Please input your option: ");
            int userOption = new Scanner(System.in).nextInt();
            switch (userOption) {
                case 0:
                    keyValue = false;
                    break;
                case 1:
                    applicationWithoutUIView.newBook();
                    break;
                case 2:
                    applicationWithoutUIView.findABook();
                    break;
                case 3:
                    applicationWithoutUIView.updateABook();
                    break;
                case 4:
                    applicationWithoutUIView.deleteABook();
                    break;
                case 5:
                    applicationWithoutUIView.printTheBookList();
                    break;
                default:
                    System.out.println("Please input the number from 0 to 5!");
            }
        }
    }

}
