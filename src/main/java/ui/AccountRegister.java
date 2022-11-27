package ui;
import account_creation_use_case.AccountRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class AccountRegister extends JPanel implements ActionListener {

    JTextField userid = new JTextField(15);

    JPasswordField password = new JPasswordField(15);
    JPasswordField repeatPassword = new JPasswordField(15);

    AccountCreationController accountCreationController;


    public AccountRegister(AccountCreationController controller) {

        this.accountCreationController = controller;

        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Choose username"), userid);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);

        JButton signUp = new JButton("Sign up");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);

    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            accountCreationController.create(userid.getText(),
                    String.valueOf(password.getPassword()));
            JOptionPane.showMessageDialog(this, "%s created.".formatted(userid.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
