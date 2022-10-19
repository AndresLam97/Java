package LessonThirteen.ApplicationWithoutUI.Utilities;

import LessonThirteen.Classes.Book;
import LessonThirteen.Classes.FileResource;
import LessonThirteen.Constants.EnvironmentConstants;
import LessonThirteen.Interfaces.WorkingWithResourcesMethods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WorkingWithResourcesController implements WorkingWithResourcesMethods {

    public List<Book> loadBookFromResource(EnvironmentConstants environmentConstants) {
        List<Book> bookList = new ArrayList<>();
        if (environmentConstants.equals(EnvironmentConstants.FILE)) {
            FileResource fileWorker = new FileResource(System.getProperty("user.dir") +
                    "\\LearnAppium\\ItemsForLessonThirteen\\Files\\currentBookListFile.txt");
            List<String> stringDataList = fileWorker.getData();
            if (stringDataList == null) {
                return bookList;
            }
            bookList = convertStringDataToBook(stringDataList);
        }
        if (environmentConstants.equals(EnvironmentConstants.DATABASE)) {

        }
        return bookList;
    }

    @Override
    public void saveBookToResource(EnvironmentConstants environmentConstants, List<Book> bookList) {
        if (environmentConstants.equals(EnvironmentConstants.FILE)) {
            FileResource fileWorker = new FileResource(System.getProperty("user.dir") +
                    "\\LearnAppium\\ItemsForLessonThirteen\\Files\\currentBookListFile.txt");
            fileWorker.saveData(bookList);
        }
        if (environmentConstants.equals(EnvironmentConstants.DATABASE)) {

        }
    }

    private List<Book> convertStringDataToBook(List<String> stringDataList) {
        List<Book> bookList = new ArrayList<>();
        if (stringDataList.isEmpty()) {
            return bookList;
        }
        for (String stringData : stringDataList) {
            String[] splittedStringList = stringData.split("-");
            if (splittedStringList.length != 5) {
                continue;
            }
            String[] splittedDate = splittedStringList[4].split("/");
            if (splittedDate.length != 3) {
                continue;
            }
            Calendar publicationDate = Calendar.getInstance();
            publicationDate.set(Integer.parseInt(splittedDate[2]), Integer.parseInt(splittedDate[0]), Integer.parseInt(splittedDate[1]));

            bookList.add(new Book(Integer.parseInt(splittedStringList[0]), splittedStringList[1],
                    splittedStringList[2], Integer.parseInt(splittedStringList[3]), publicationDate));
        }
        return bookList;
    }

}
