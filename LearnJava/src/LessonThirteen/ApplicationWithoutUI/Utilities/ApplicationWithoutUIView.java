package LessonThirteen.ApplicationWithoutUI.Utilities;

import LessonThirteen.Classes.Book;
import LessonThirteen.Constants.EnvironmentConstants;
import LessonThirteen.Interfaces.ApplicationViewMethod;

import java.util.*;

public class ApplicationWithoutUIView implements ApplicationViewMethod {
    private List<Book> bookList = new ArrayList<>();
    private WorkingWithResourcesController workingWithResourcesController = new WorkingWithResourcesController();

    public ApplicationWithoutUIView() {
        this.bookList = workingWithResourcesController.loadBookFromResource(EnvironmentConstants.FILE);
    }

    public void newBook() {
        int iSBN;
        String bookName;
        String authorName;
        int pageNumber;
        Calendar publicationDate;
        iSBN = ApplicationWithoutUIController.inputISBN(bookList);
        bookName = ApplicationWithoutUIController.inputBookName();
        authorName = ApplicationWithoutUIController.inputAuthorName();
        pageNumber = ApplicationWithoutUIController.inputPageNumber();
        publicationDate = ApplicationWithoutUIController.inputPublicationDate();
        bookList.add(new Book(iSBN, bookName, authorName, pageNumber, publicationDate));
        System.out.println("Add new book successful.\n");
    }

    public void findABook() {
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty, please add a book then retry again!\n");
            return;
        }
        int bookISBN = ApplicationWithoutUIController.inputISBN();
        for (Book book : bookList) {
            if (book.getiSBN() == bookISBN) {
                System.out.println("Found the book !!!");
                System.out.println("The book information: ");
                System.out.println(book.toString());
                return;
            }
        }
        System.out.println("There is no any book have ISBN = " + bookISBN + ". Please retry again!\n");
    }

    public void updateABook() {
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty, please add a book then retry again!\n");
            return;
        }
        int bookISBN = ApplicationWithoutUIController.inputISBN();
        Map<Integer, Book> foundedBook = ApplicationWithoutUIController.findBookWithISBN(bookISBN, bookList);
        if (foundedBook != null) {
            Set<Integer> totalKeysInMap = foundedBook.keySet();
            for (Integer key : totalKeysInMap) {
                ApplicationWithoutUIController.updateBookRecord(key, bookList);
            }
        } else {
            System.out.println("There is no any book has ISBN = " + bookISBN + ". Please retry again!\n");
        }
    }

    public void deleteABook() {
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty, please add a book then retry again!\n");
            return;
        }
        int bookISBN = ApplicationWithoutUIController.inputISBN();
        Map<Integer, Book> foundedBook = ApplicationWithoutUIController.findBookWithISBN(bookISBN, bookList);
        if (foundedBook != null) {
            Set<Integer> totalKeysInMap = foundedBook.keySet();
            for (Integer key : totalKeysInMap) {
                bookList.remove(key.intValue());
            }
            System.out.println("Remove book successful!\n");
        } else {
            System.out.println("There is no any book has ISBN = " + bookISBN + ". Please retry again!\n");
        }
    }

    public void printTheBookList() {
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty, please add a book then retry again!\n");
            return;
        }
        System.out.println("The book list contains " + bookList.size() + " book(s):");
        for (int index = 0; index < bookList.size(); index++) {
            System.out.println("Book " + (index + 1) + ":");
            System.out.println(bookList.get(index).toString());
            System.out.println("");
        }
    }

    public void exitProgram() {
        workingWithResourcesController.saveBookToResource(EnvironmentConstants.FILE, bookList);
    }
}
