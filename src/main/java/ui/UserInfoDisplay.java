package ui;
import accountInfoUseCase.AccountInfoInteractor;
import controller.AccountInfoController;
import entity.UserAccount;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class UserInfoDisplay extends JFrame {

    final UserAccount account;
    final AccountGateway gateway;
    JPanel main = new JPanel();

    public UserInfoDisplay(UserAccount account, AccountGateway gateway) throws IOException {
        this.account = account;
        this.gateway = gateway;
        this.setTitle("User Information Page");
        this.setSize(1000, 800);

        AccountInfoInteractor interactor = new AccountInfoInteractor(gateway);
        AccountInfoController controller = new AccountInfoController(interactor);

        JLabel password1 = new JLabel("Password:");
        JLabel password2 = new JLabel(this.account.getPassword());
        JButton password3 = new JButton("Update Password");
        JTextField password4 = new JTextField(10);
        JLabel age1 = new JLabel("Age:");
        JLabel age2 = new JLabel(String.valueOf(this.account.getAge()));
        JButton age3 = new JButton("Update Age");
        JTextField age4 = new JTextField(10);
        JLabel gender1 = new JLabel("Gender:");
        JLabel gender2 = new JLabel(String.valueOf(this.account.getGender()));
        JButton gender3 = new JButton("Update Gender");
        JTextField gender4 = new JTextField(10);
        JLabel weight1 = new JLabel("Weight:");
        JLabel weight2 = new JLabel(String.valueOf(this.account.getWeight()));
        JButton weight3 = new JButton("Update Weight");
        JTextField weight4 = new JTextField(10);
        JLabel height1 = new JLabel("Height:");
        JLabel height2 = new JLabel(String.valueOf(this.account.getHeight()));
        JButton height3 = new JButton("Update Height");
        JTextField height4 = new JTextField(10);
        JButton feedback = new JButton("Generate Feedback");

        JPanel passwordPanel = new JPanel();
        JPanel agePanel = new JPanel();
        JPanel genderPanel = new JPanel();
        JPanel weightPanel = new JPanel();
        JPanel heightPanel = new JPanel();
        JPanel feedbackPanel = new JPanel();

        passwordPanel.add(password1);
        passwordPanel.add(password2);
        passwordPanel.add(password4);
        passwordPanel.add(password3);
        agePanel.add(age1);
        agePanel.add(age2);
        agePanel.add(age4);
        agePanel.add(age3);
        genderPanel.add(gender1);
        genderPanel.add(gender2);
        genderPanel.add(gender4);
        genderPanel.add(gender3);
        weightPanel.add(weight1);
        weightPanel.add(weight2);
        weightPanel.add(weight4);
        weightPanel.add(weight3);
        heightPanel.add(height1);
        heightPanel.add(height2);
        heightPanel.add(height4);
        heightPanel.add(height3);
        feedbackPanel.add(feedback);

        main.setLayout(new GridLayout(6, 0));
        main.add(passwordPanel);
        main.add(agePanel);
        main.add(genderPanel);
        main.add(weightPanel);
        main.add(heightPanel);
        main.add(feedbackPanel);

        password3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(password4.getText().equals(""))) {
                    String newpassword = password4.getText();
                    try {
                        controller.UpdatePassword(newpassword, account.getUserid());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        age3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(age4.getText().equals(""))) {
                    int newage = Integer.parseInt(age4.getText());
                    try {
                        controller.UpdateAge(newage, account.getUserid());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        gender3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(gender4.getText().equals(""))) {
                    char newgender = gender4.getText().charAt(0);
                    try {
                        controller.UpdateGender(newgender, account.getUserid());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        weight3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(weight4.getText().equals(""))) {
                    float newweight = Float.parseFloat(weight4.getText());
                    try {
                        controller.UpdateWeight(newweight, account.getUserid());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        height3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(height4.getText().equals(""))) {
                    float newheight = Float.parseFloat(height4.getText());
                    try {
                        controller.UpdateHeight(newheight, account.getUserid());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, controller.GiveFeedback(account.getHeight(),
                        account.getWeight(), account.getUserid()));
            }
        });

        this.add(main);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) throws IOException {
        UserAccount Asad = new UserAccount("aaa", "abcde", 23, 'M', 70, 1.8f);
        ArrayList<UserAccount> accounts = new ArrayList<>();
        AccountGateway gateway = new AccountGatewayImplementation();
        gateway.saveAccounts(accounts);
        JFrame ui = new UserInfoDisplay(Asad, gateway);
        ui.setVisible(true);
    }
}
