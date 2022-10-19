package LessonThirteen.ApplicationWithoutUI.Utilities;

import LessonThirteen.Classes.Book;
import LessonThirteen.Constants.EvironmentConstants;
import LessonThirteen.Interfaces.WorkingWithResourcesMethods;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithResourcesController implements WorkingWithResourcesMethods {

    public List<Book> loadBookFromResource(EvironmentConstants evironmentConstants) {
        List<Book> bookList = new ArrayList<>();
        if(evironmentConstants.equals(EvironmentConstants.FILE))
        {

        }
        if(evironmentConstants.equals(EvironmentConstants.DATABASE))
        {

        }
        return bookList;
    }

    @Override
    public void saveBookToResource(EvironmentConstants evironmentConstants) {

    }

    @Override
    public void updateBookToResource(EvironmentConstants evironmentConstants) {

    }


}
