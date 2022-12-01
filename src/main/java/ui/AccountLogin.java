package ui;

import gateway.AccountGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class AccountLogin extends JFrame {

    JTextField userid = new JTextField(15);

    JPasswordField password = new JPasswordField(15);
    AccountRegisterUI registerUI = new AccountRegisterUI();


    /**
     * A window with a title and a JButton.
     */
    public AccountLogin() throws IOException {

        AccountGateway gateway = registerUI.getGateway();

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("User Id"), userid);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log in");
        JButton register = new JButton("Register");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(register);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!(gateway.getAccounts().containsKey(userid.getText()))) {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, we don't have this account in out database. Please sign up first.");
                    } else if (String.valueOf(password.getPassword()).equals(
                            gateway.getAccounts().get(userid.getText()).getPassword())) {
                        UserInfoDisplay infopage = new UserInfoDisplay(userid.getText(), gateway);
                        infopage.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, your userid or password is incorrect. Please try again!");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                userid.setText("");
                password.setText("");
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUI.setVisible(true);
            }
        });

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

}
