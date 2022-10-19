package LessonThirteen.Interfaces;

import LessonThirteen.Classes.Book;
import LessonThirteen.Constants.EvironmentConstants;

import java.util.List;

public interface WorkingWithResourcesMethods {
    List<Book> loadBookFromResource(EvironmentConstants evironmentConstants);
    void saveBookToResource(EvironmentConstants evironmentConstants);
    void updateBookToResource(EvironmentConstants evironmentConstants);
}
