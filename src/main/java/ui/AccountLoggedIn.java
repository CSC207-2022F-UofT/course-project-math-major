package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountLoggedIn extends JFrame implements ActionListener {

    JTextField username = new JTextField(15);

    public AccountLoggedIn() {

        JLabel title = new JLabel("Logged-in Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logOut = new JButton("Log out");
        JButton changePassword = new JButton("Change password");

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        username.setEditable(false);

        JPanel buttons = new JPanel();
        buttons.add(logOut);
        buttons.add(changePassword);

        logOut.addActionListener(this);
        changePassword.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(buttons);

        this.setContentPane(main);
        this.pack();
    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
