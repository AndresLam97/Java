package LessonThirteen.Application;
import javax.swing.*;

public class LessonThirteenMainClass {
    public static void main(String[] args) {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    ApplicationMainController.init();
                }
            });
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println(System.getProperty("user.dir"));
    }


}
