package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountLogin  extends JFrame implements ActionListener {

    JTextField userid = new JTextField(15);

    JPasswordField password = new JPasswordField(15);


    /**
     * A window with a title and a JButton.
     */
    public AccountLogin() {

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

        logIn.addActionListener(this);
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
}
