package LessonThirteen.ApplicationWithinUI.Login;

public class LoginController implements LoginAbilities{
    @Override
    public boolean checkUserName(String userNameOrEmail) {
        return false;
    }

    @Override
    public boolean checkPassword(String passWord) {
        return false;
    }

    @Override
    public void login(String userNameOrEmail, String passWord) {

    }

    @Override
    public void forgotInformation() {

    }

    @Override
    public void registerAccount() {

    }
}
