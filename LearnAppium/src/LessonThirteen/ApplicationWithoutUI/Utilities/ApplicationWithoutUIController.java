package LessonThirteen.ApplicationWithoutUI.Utilities;

import LessonThirteen.Classes.Book;

import java.util.*;

public class ApplicationWithoutUIController {

    public static int inputISBN(List<Book> currentBookList) {
        int iSBN = 0;
        Map<Boolean, String> validateResult = new HashMap<>();
        while (true) {
            try {
                System.out.print("Please input ISBN: ");
                iSBN = new Scanner(System.in).nextInt();
                validateResult = ValidateDataController.validateISBN(iSBN, currentBookList);
                if (validateResult.containsKey(true)) {
                    break;
                } else {
                    System.out.println(validateResult.get(false));
                }
            } catch (Exception ex) {
                System.out.println("Please input the number type only!");
            }
        }
        return iSBN;
    }

    public static int inputISBN() {
        int bookISBN = 0;
        try {
            System.out.print("Input the book ISBN: ");
            bookISBN = new Scanner(System.in).nextInt();
        } catch (Exception ex) {
            System.out.println("Please input the number type only!");
        }
        return bookISBN;
    }

    public static String inputBookName() {
        String bookName = "";
        while (true) {
            System.out.print("Please input book name: ");
            bookName = new Scanner(System.in).nextLine();
            if (ValidateDataController.validateBookName(bookName)) {
                System.out.println("Please input at least one character!");
            } else {
                break;
            }
        }
        return bookName;
    }

    public static String inputAuthorName() {
        String authorName = "";
        while (true) {
            System.out.print("Please input book name: ");
            authorName = new Scanner(System.in).nextLine();
            if (ValidateDataController.validateAuthorName(authorName)) {
                System.out.println("Please input at least one character!");
            } else {
                break;
            }
        }
        return authorName;
    }

    public static int inputPageNumber() {
        int pageNumber = 0;
        while (true) {
            try {
                System.out.print("Please input ISBN: ");
                pageNumber = new Scanner(System.in).nextInt();
                if (ValidateDataController.validatePageNumber(pageNumber)) {
                    System.out.println("Please input the positive number only!");
                } else {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Please input the number type only!");
            }
        }
        return pageNumber;
    }

    public static Calendar inputPublicationDate() {
        Calendar publicationDate = Calendar.getInstance();
        Map<Boolean, String> result = new HashMap<>();
        String inputtedDate = "";
        String[] splittedDate;
        while (true) {
            System.out.print("Input the publication date (MM/DD/YYYY): ");
            inputtedDate = new Scanner(System.in).nextLine();
            splittedDate = inputtedDate.split("/");
            result = ValidateDataController.validatePublicationDate(splittedDate);
            if (result.containsKey(true)) {
                break;
            }
            if (result.containsKey(false)) {
                System.out.println(result.get(false).toString());
            }
        }
        publicationDate.set(Calendar.MONTH, Integer.parseInt(splittedDate[0]));
        publicationDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splittedDate[1]));
        publicationDate.set(Calendar.YEAR, Integer.parseInt(splittedDate[2]));
        return publicationDate;
    }

    public static void updateBookRecord(int bookIndex, List<Book> currentBookList)
    {
        currentBookList.get(bookIndex).setiSBN(inputISBN(currentBookList));
        currentBookList.get(bookIndex).setBookName(inputBookName());
        currentBookList.get(bookIndex).setAuthorName(inputAuthorName());
        currentBookList.get(bookIndex).setPageNumber(inputPageNumber());
        currentBookList.get(bookIndex).setPublicationDate(inputPublicationDate());
        System.out.println("Update successfully");
    }

    public static Book findBookWithISBN(int bookISBN,List<Book> currentBookList)
    {
        for(int )


        return null;
    }
}