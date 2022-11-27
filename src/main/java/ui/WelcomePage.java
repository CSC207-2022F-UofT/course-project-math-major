package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WelcomePage extends JFrame implements ActionListener {
    public WelcomePage() {

        JLabel title = new JLabel("Welcome Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logIn = new JButton("Log in");
        JButton signUp = new JButton("Sign up");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(signUp);

        logIn.addActionListener(this);
        signUp.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
