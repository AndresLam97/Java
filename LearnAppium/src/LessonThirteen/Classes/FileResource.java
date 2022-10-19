package LessonThirteen.Classes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileResource extends SuperResource{

    private String filePath;

    public FileResource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> getData() {
        List<String> dataList = new ArrayList<>();
        Path newFilePath = Paths.get(this.filePath);
        if(!Files.exists(newFilePath))
        {
            System.out.println("The file is not exist, please retry again with another file!\n");
            return null;
        }
        try (FileInputStream fileInputStream = new FileInputStream(newFilePath.toAbsolutePath().toString());
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader))
        {
            String data = bufferedReader.readLine();
            if(data == null){ return null;}
            while(data != null){
                dataList.add(data);
                data = bufferedReader.readLine();
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return dataList;
    }

    @Override
    public void saveData(List<Book> bookList) {
        if(bookList.isEmpty())
        {
            System.out.println("Save data failed because the list is empty!");
            return;
        }
        Path newFilePath = Paths.get(filePath);
        if(!Files.exists(newFilePath))
        {
            System.out.println("The file is not exist, please retry again with another file!\n");
            return;
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(newFilePath.toAbsolutePath().toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        )
        {
            for(Book book : bookList)
            {
                bufferedWriter.write(book.getiSBN() + "-" + book.getBookName() + "-" + book.getAuthorName() +
                        "-" + book.getPageNumber() + "-" + book.getPublicationDate() + "\n");
            }
        }catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFilePath()
    {
        return this.filePath;
    }

}
