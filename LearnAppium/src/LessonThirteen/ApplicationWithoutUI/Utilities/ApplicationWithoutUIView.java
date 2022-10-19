package LessonThirteen.ApplicationWithoutUI.Utilities;

import LessonThirteen.Classes.Book;
import LessonThirteen.Constants.EvironmentConstants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ApplicationWithoutUIView {
    private List<Book> bookList = new ArrayList<>();
    private WorkingWithResourcesController workingWithResourcesController = new WorkingWithResourcesController();

    public ApplicationWithoutUIView()
    {
        this.bookList = workingWithResourcesController.loadBookFromResource(EvironmentConstants.FILE);
    }

    public void newBook(){
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
        System.out.println("Add new book successful");

    }

    public void findABook(){
        if(bookList.isEmpty())
        {
            System.out.println("The book list is empty, please add a book then retry again!");
            return;
        }
        int bookISBN = ApplicationWithoutUIController.inputISBN();
        for(Book book : bookList)
        {
            if(book.getiSBN() == bookISBN)
            {
                System.out.println("Found the book !!!");
                System.out.println(book.toString());
            }
        }
        System.out.println("There is no any book have ISBN = " + bookISBN + ". Please retry again!");
    }

    public void updateABook(){
        if(bookList.isEmpty())
        {
            System.out.println("The book list is empty, please add a book then retry again!");
            return;
        }
        int bookISBN = ApplicationWithoutUIController.inputISBN();
        ApplicationWithoutUIController.updateBookRecord(bookISBN,bookList);
    }

    public void deleteABook(){
        if(bookList.isEmpty())
        {
            System.out.println("The book list is empty, please add a book then retry again!");
            return;
        }
        int bookISBN = ApplicationWithoutUIController.inputISBN();
        int foundedBookFlag = -1;
        for(int index = 0; index < bookList.size();index++)
        {
            if(bookList.get(index).getiSBN() == bookISBN)
            {
                foundedBookFlag = index;
            }
        }
        if(foundedBookFlag == -1)
        {
            System.out.println("There is no any book have ISBN = " + bookISBN + ". Please retry again!");
        }
        else
        {
        }
    }
    public void printTheBookList(){
        if(bookList.isEmpty())
        {
            System.out.println("The book list is empty, please add a book then retry again!");
            return;
        }
        System.out.println("The book list contains " + bookList.size() + " book(s):");
        for (Book book : bookList) {
            System.out.println(book.toString());
            System.out.println("=====================================================");
        }
    }


}
