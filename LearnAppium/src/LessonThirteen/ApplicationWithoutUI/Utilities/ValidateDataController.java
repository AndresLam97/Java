package LessonThirteen.ApplicationWithoutUI.Utilities;

import LessonThirteen.Classes.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateDataController {
    public static Map<Boolean, String> validateISBN(int ISBN, List<Book> currentBookList) {
        Map<Boolean, String> result = new HashMap<>();
        try {
            if (ISBN < 0) {
                throw new Exception("Please input the positive number only!");
            }
            for (Book book : currentBookList) {
                if (book.getiSBN() == ISBN) {
                    throw new Exception("The ISBN already exists, please input another ISBN!");
                }
            }
        } catch (Exception ex) {
            result.put(false, ex.getMessage());
            return result;
        }
        result.put(true, "Success");
        return result;
    }

    public static boolean validateBookName(String bookName) {
        return bookName.equals("");
    }

    public static boolean validateAuthorName(String authorName) {
        return authorName.equals("");
    }

    public static boolean validatePageNumber(int pageNumber) {
        return pageNumber < 0;
    }

    public static Map<Boolean, String> validatePublicationDate(String[] publicationDate) {
        Map<Boolean, String> result = new HashMap<>();
        boolean isLeapYear;
        try {
            if (publicationDate.length != 3) {
                throw new Exception("The date format is incorrect, please retry again!");
            }
            isLeapYear = Integer.parseInt(publicationDate[2]) % 4 == 0;
            if (Integer.parseInt(publicationDate[0]) < 1 || Integer.parseInt(publicationDate[0]) > 12) {
                throw new Exception("Please input the month between 1 and 12!");
            }
            if ((Integer.parseInt(publicationDate[0]) == 2 && isLeapYear) &&
                    (Integer.parseInt(publicationDate[1]) < 1 || Integer.parseInt(publicationDate[1]) > 29)) {
                throw new Exception("Please input the day between 1 and 29!");
            }
            if ((Integer.parseInt(publicationDate[0]) == 2 && !isLeapYear) &&
                    (Integer.parseInt(publicationDate[1]) < 1 || Integer.parseInt(publicationDate[1]) > 28)) {
                throw new Exception("Please input the day between 1 and 28!");
            }
            if ((Integer.parseInt(publicationDate[1]) < 1 || Integer.parseInt(publicationDate[1]) > 31) &&
                    (Integer.parseInt(publicationDate[0]) == 1 || Integer.parseInt(publicationDate[0]) == 3 ||
                            Integer.parseInt(publicationDate[0]) == 5 || Integer.parseInt(publicationDate[0]) == 7 ||
                            Integer.parseInt(publicationDate[0]) == 8 || Integer.parseInt(publicationDate[0]) == 10 ||
                            Integer.parseInt(publicationDate[0]) == 12)) {
                throw new Exception("Please input the day between 1 and 31!");
            }
            if ((Integer.parseInt(publicationDate[1]) < 1 || Integer.parseInt(publicationDate[1]) > 30) &&
                    (Integer.parseInt(publicationDate[0]) == 4 || Integer.parseInt(publicationDate[0]) == 6 ||
                            Integer.parseInt(publicationDate[0]) == 9 || Integer.parseInt(publicationDate[0]) == 11)) {
                throw new Exception("Please input the day between 1 and 30!");
            }
            if (Integer.parseInt(publicationDate[2]) < 0) {
                throw new Exception("Please input the positive year value!");
            }
        } catch (Exception ex) {
            result.put(false, ex.getMessage());
            return result;
        }
        result.put(true, "Success");
        return result;
    }
}
