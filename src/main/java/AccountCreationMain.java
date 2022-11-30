import ui.*;
import account_creation_use_case.AccountInputBoundary;
import account_creation_use_case.AccountPresenter;
import account_creation_use_case.AccountDsGateway;
import account_creation_use_case.AccountInteractor;
import gateway.AccountGateway;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AccountCreationMain {
    public static void main(String[] args) {


        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);


        AccountDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        AccountPresenter presenter = new AccountCreationResponseFormatter();
        UserAccount userFactory = new UserAccount(null, null, 0,'m', 0,0);
        AccountInputBoundary interactor = new AccountInteractor(user, presenter, userFactory);
        AccountCreationController userRegisterController = new AccountCreationController(
                interactor
        );


        AccountRegister registerScreen = new AccountRegister(userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
        WelcomePage welcomepage = new WelcomePage();
        AccountLogin accountLogin = new AccountLogin();
        AccountLoggedIn accountLoggedIn = new AccountLoggedIn();
        screens.add(welcomepage, "register");
        screens.add(accountLogin, "login");
        screens.add(accountLoggedIn, "loggedIn");


    }


}