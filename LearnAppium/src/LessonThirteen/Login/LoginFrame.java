package LessonThirteen.Login;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame()
    {
        // Set the title of frame
        this.setTitle("Login");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle loginFrameSize = new Rectangle(currentScreenSize.width/4,currentScreenSize.height/2);
        this.setBounds(loginFrameSize);

        this.setResizable(false);
        this.getContentPane().add(createLabelsAndButtons(loginFrameSize));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JPanel createLabelsAndButtons(Rectangle loginFrameSize )
    {
        // Create panel variables
        JPanel mainPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel forgotOrRegisterInformationPanel = new JPanel();
        JPanel loginAndRememberMeButtonsPanel = new JPanel();

        // Create label variables
        JLabel loginPic = new JLabel();
        JLabel userNameOrEmailLabel = new JLabel("User name or email address");
        JLabel passWordLabel = new JLabel("Password");
        JLabel userNameOrEmailErrorLabel = new JLabel();
        JLabel passWordErrorLabel = new JLabel();
        JLabel forgotOrRegisterSeparator = new JLabel("|");

        // Create button variables
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton forgotPasswordButton = new JButton("Lost your password?");

        // Create checkbox variables
        JCheckBox rememberMeCheckbox = new JCheckBox("Remember me");

        // Create text and password field variables
        JTextField userNameOrEmailTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        // Set panel layout
        mainPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        topPanel.setLayout(new FlowLayout());
        forgotOrRegisterInformationPanel.setLayout(new FlowLayout());
        loginAndRememberMeButtonsPanel.setLayout(new FlowLayout());

        //Set panel size
        mainPanel.setBounds(loginFrameSize);
        topPanel.setPreferredSize(new Dimension(new Double(mainPanel.getWidth()/1.3).intValue(),
                new Double(mainPanel.getWidth()/1.3).intValue()));


        // Config the data for variables
        String loginLogoPath = System.getProperty("user.dir") +"\\LearnAppium\\ItemsForLessonThirteen\\LoginPageLabelLogo.jpg";
        loginPic.setIcon(new ImageIcon(loginLogoPath));
        /*loginPic.setPreferredSize(new Dimension(new Double(mainPanel.getWidth()/1.3).intValue(),
                     new Double(mainPanel.getWidth()/1.3).intValue()));*/

        // Add components to panels
        //topPanel.setBounds(new Rectangle(20,20));
        topPanel.add(loginPic);
        loginAndRememberMeButtonsPanel.add(rememberMeCheckbox);
        loginAndRememberMeButtonsPanel.add(loginButton);
        centerPanel.add(userNameOrEmailLabel);
        centerPanel.add(userNameOrEmailTextField);
        centerPanel.add(userNameOrEmailErrorLabel);
        centerPanel.add(passWordLabel);
        centerPanel.add(passwordField);
        centerPanel.add(passWordErrorLabel);
        centerPanel.add(loginAndRememberMeButtonsPanel);
        forgotOrRegisterInformationPanel.add(registerButton);
        forgotOrRegisterInformationPanel.add(forgotOrRegisterSeparator);
        forgotOrRegisterInformationPanel.add(forgotPasswordButton);

        mainPanel.add(BorderLayout.NORTH,topPanel);
        mainPanel.add(BorderLayout.CENTER,centerPanel);
        mainPanel.add(BorderLayout.SOUTH,forgotOrRegisterInformationPanel);


        return mainPanel;
    }





}
