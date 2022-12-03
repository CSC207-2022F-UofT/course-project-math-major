package ui;

import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class AccountRegisterUI extends JFrame{

    JPanel main = new JPanel();
    JTextField userid = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JPasswordField repeatPassword = new JPasswordField(15);
    private final AccountGateway gateway = new AccountGatewayImplementation();

    private final RecipeGateway rgateway = new RecipeGatewayImplementation();

    public AccountRegisterUI() throws FileNotFoundException {

        this.setTitle("Register Screen");

        LabelTextPanel useridInfo = new LabelTextPanel(
                new JLabel("Choose username"), userid);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);
        JButton signup = new JButton("Sign up");
        JButton cancel = new JButton("cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(signup);
        buttonPanel.add(cancel);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!(Arrays.equals(password.getPassword(), repeatPassword.getPassword()))) {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, the password you entered the first time does not match the password " +
                                        "u entered the second time. Please try again.");
                    } else if (gateway.addAccount(userid.getText(), String.valueOf(password.getPassword()))) {
                        JOptionPane.showMessageDialog(null,
                                "You have registered successfully. Thank you for supporting our app!");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, the userid you entered already exists. Please try a different one.");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        main.setLayout(new GridLayout(4,0));
        main.add(useridInfo);
        main.add(passwordInfo);
        main.add(repeatPasswordInfo);
        main.add(buttonPanel);

        this.add(main);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public AccountGateway getGateway() {
        return gateway;
    }

    public RecipeGateway getRGateway() {return rgateway;}
}
