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
import java.util.*;

public class UserInfoDisplay extends JFrame {

    final String userid;
    final AccountGateway gateway;
    JPanel main = new JPanel();
    private String password;
    private int age;
    private char gender;
    private float weight;
    private float height;

    public UserInfoDisplay(String userid, AccountGateway gateway) throws IOException {
        this.userid = userid;
        this.gateway = gateway;
        this.setTitle("User Information Page");
        this.setSize(1200, 1000);
        this.password = gateway.getAccounts().get(userid).getPassword();
        this.age = gateway.getAccounts().get(userid).getAge();
        this.gender = gateway.getAccounts().get(userid).getGender();
        this.weight = gateway.getAccounts().get(userid).getWeight();
        this.height = gateway.getAccounts().get(userid).getHeight();

        AccountInfoInteractor interactor = new AccountInfoInteractor(gateway);
        AccountInfoController controller = new AccountInfoController(interactor);

        JLabel password1 = new JLabel("Password:");
        JLabel password2 = new JLabel(password);
        JButton password3 = new JButton("Update Password");
        JTextField password4 = new JTextField(10);
        JLabel age1 = new JLabel("Age:");
        JLabel age2 = new JLabel(String.valueOf(age));
        JButton age3 = new JButton("Update Age");
        JTextField age4 = new JTextField(10);
        JLabel gender1 = new JLabel("Gender:");
        JLabel gender2 = new JLabel(String.valueOf(gender));
        JButton gender3 = new JButton("Update Gender");
        JTextField gender4 = new JTextField(10);
        JLabel weight1 = new JLabel("Weight:");
        JLabel weight2 = new JLabel(String.valueOf(weight));
        JButton weight3 = new JButton("Update Weight");
        JTextField weight4 = new JTextField(10);
        JLabel height1 = new JLabel("Height:");
        JLabel height2 = new JLabel(String.valueOf(height));
        JButton height3 = new JButton("Update Height");
        JTextField height4 = new JTextField(10);
        JButton feedback = new JButton("Generate Feedback");
        JButton editrecipe = new JButton("Edit Recipe");
        JButton showrank = new JButton("Show Rank");

        JPanel passwordPanel = new JPanel();
        JPanel agePanel = new JPanel();
        JPanel genderPanel = new JPanel();
        JPanel weightPanel = new JPanel();
        JPanel heightPanel = new JPanel();
        JPanel specialPanel = new JPanel();

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
        specialPanel.add(feedback);
        specialPanel.add(editrecipe);
        specialPanel.add(showrank);

        main.setLayout(new GridLayout(6, 0));
        main.add(passwordPanel);
        main.add(agePanel);
        main.add(genderPanel);
        main.add(weightPanel);
        main.add(heightPanel);
        main.add(specialPanel);

        password3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(password4.getText().equals(""))) {
                    String newpassword = password4.getText();
                    try {
                        controller.UpdatePassword(newpassword, userid);
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
                        controller.UpdateAge(newage, userid);
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
                        controller.UpdateGender(newgender, userid);
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
                        controller.UpdateWeight(newweight, userid);
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
                        controller.UpdateHeight(newheight, userid);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,
                            controller.GiveFeedback(gateway.getAccounts().get(userid).getHeight(),
                                    gateway.getAccounts().get(userid).getWeight(), userid));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        editrecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecipeInitialDisplay rd = new RecipeInitialDisplay();
            }
        });

        this.add(main);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) throws IOException {
        UserAccount Asad = new UserAccount("aaa", "abcde", 23, 'M',
                70, 1.80f);
        UserAccount Wasd = new UserAccount("bbb", "qwert", 98, 'F',
                40, 1.62f);
        Map<String, UserAccount> accounts = new HashMap<>();
        accounts.put("aaa", Asad);
        accounts.put("bbb", Wasd);
        AccountGateway gateway = new AccountGatewayImplementation();
        gateway.saveAccounts(accounts);
        AccountInfoInteractor i = new AccountInfoInteractor(gateway);
        AccountInfoController c = new AccountInfoController(i);
        c.UpdateAge(20, "aaa");
        UserInfoDisplay ui = new UserInfoDisplay("aaa", gateway);
        ui.setVisible(true);
    }
}
