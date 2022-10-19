package LessonThirteen.Classes;

import java.util.Calendar;

public class Book {
    private int iSBN;
    private String bookName;
    private String authorName;
    private int pageNumber;
    private Calendar publicationDate;

    public Book() {
    }

    public Book(int iSBN, String bookName, String authorName, int pageNumber, Calendar publicationDate) {
        this.iSBN = iSBN;
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNumber = pageNumber;
        this.publicationDate = publicationDate;
    }

    public int getiSBN() {
        return iSBN;
    }

    public void setiSBN(int iSBN) {
        this.iSBN = iSBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String toString() {
        return String.format("ISDN: %d.\n" +
                "Book name: %s.\n" +
                "Author: %s.\n" +
                "Page number: %d.\n" +
                "Publication date: %s.\n", this.iSBN, this.bookName, this.authorName, this.pageNumber, this.publicationDate.toString());
    }

}
