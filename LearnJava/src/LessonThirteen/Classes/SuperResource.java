package LessonThirteen.Classes;

import java.util.List;

public abstract class SuperResource {
    public SuperResource(){}
    public void connect() {};
    public abstract List<String> getData();
    public abstract void saveData(List<Book> bookList);
    public void close() {};
}
