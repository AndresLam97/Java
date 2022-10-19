package LessonThirteen.Interfaces;

import LessonThirteen.Classes.Book;
import LessonThirteen.Constants.EnvironmentConstants;

import java.util.List;

public interface WorkingWithResourcesMethods {
    List<Book> loadBookFromResource(EnvironmentConstants environmentConstants);

    void saveBookToResource(EnvironmentConstants environmentConstants, List<Book> bookList);
}
