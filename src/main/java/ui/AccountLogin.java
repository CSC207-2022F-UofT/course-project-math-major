package ui;
import entity.UserAccount;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountLogin  extends JFrame implements ActionListener {

    JTextField userid = new JTextField(15);

    JPasswordField password = new JPasswordField(15);


    /**
     * A window with a title and a JButton.
     */
    public AccountLogin(AccountGateway gateway) {

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("User Id"), userid);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (String.valueOf(password.getPassword()).equals(
                            gateway.getAccounts().get(userid.getText()).getPassword())) {
                        UserInfoDisplay infopage = new UserInfoDisplay(userid.getText(), gateway);
                        infopage.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, your userid or password is incorrect. Please try again!");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public static void main(String[] args) throws IOException {
        UserAccount aaa = new UserAccount("aaa", "abcde",
                21, 'M', 62.3f, 1.78f);
        Map<String, UserAccount> accounts = new HashMap<>();
        accounts.put("aaa", aaa);
        AccountGateway gateway = new AccountGatewayImplementation();
        gateway.saveAccounts(accounts);
        JFrame login = new AccountLogin(gateway);
        login.setVisible(true);
    }
}
