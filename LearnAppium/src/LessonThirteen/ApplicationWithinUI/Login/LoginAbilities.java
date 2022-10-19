package LessonThirteen.ApplicationWithinUI.Login;

public interface LoginAbilities {
    boolean checkUserName(String userNameOrEmail);
    boolean checkPassword(String passWord);
    void login(String userNameOrEmail,String passWord);
    void forgotInformation();
    void registerAccount();
}
