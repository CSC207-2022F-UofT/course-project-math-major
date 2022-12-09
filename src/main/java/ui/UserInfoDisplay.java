package ui;
import accountInfoUseCase.AccountInfoInteractor;
import controller.AccountInfoController;
import controller.RankingController;
import gateway.AccountGateway;
import gateway.RatedGateway;
import gateway.RatedGatewayImplementation;
import presenter.RankingPresenter;
import ranking_use_case.RankingInteractor;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;
import recipeui.RecipeInitialDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/** This is the User Interface of the Account Information System. Users can view and update their personal
 * information here and see the feedback. They can also go to other systems like rank system and recipe system
 * from here. **/

public class UserInfoDisplay extends JFrame {

    final String userid;
    JPanel main = new JPanel();


    public UserInfoDisplay(String userid, AccountGateway gateway) throws IOException {
        this.userid = userid;

        AccountInfoInteractor interactor = new AccountInfoInteractor(gateway);
        AccountInfoController controller = new AccountInfoController(interactor);

        this.setTitle("User Information Page");
        this.setPreferredSize(new Dimension(800, 600));

        String password = gateway.getAccounts().get(userid).getPassword();
        int age = gateway.getAccounts().get(userid).getAge();
        char gender = gateway.getAccounts().get(userid).getGender();
        float weight = gateway.getAccounts().get(userid).getWeight();
        float height = gateway.getAccounts().get(userid).getHeight();


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
        JButton exit = new JButton("Exit to Login Page");

        showrank.addActionListener(e -> {
            RankingRequestModel rankingRequestModel = new RankingRequestModel(userid,null);

            RatedGateway ratedGateway = new RatedGatewayImplementation();
            MainDisplay mainDisplay = new MainDisplay();
            RankingPresenter rankingPresenter = new RankingPresenter(mainDisplay);
            RankingInteractor rankingInteractor = new RankingInteractor(ratedGateway, rankingRequestModel, rankingPresenter);

            RankingController rankingController = new RankingController(rankingInteractor);
            RankingResponseModel rankingResponseModel = rankingController.rank(rankingRequestModel);

            rankingPresenter.showQueryRank(rankingResponseModel);
        });

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
        specialPanel.add(exit);

        main.setLayout(new GridLayout(6, 0));
        main.add(passwordPanel);
        main.add(agePanel);
        main.add(genderPanel);
        main.add(weightPanel);
        main.add(heightPanel);
        main.add(specialPanel);

        password3.addActionListener(e -> {
            if (!(password4.getText().equals(""))) {
                String newpassword = password4.getText();
                try {
                    controller.UpdatePassword(newpassword, userid);
                    password2.setText(newpassword);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            password4.setText("");
        });

        age3.addActionListener(e -> {
            if (!(age4.getText().equals(""))) {
                int newage = Integer.parseInt(age4.getText());
                try {
                    controller.UpdateAge(newage, userid);
                    age2.setText(String.valueOf(newage));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            age4.setText("");
        });

        gender3.addActionListener(e -> {
            if (!(gender4.getText().equals(""))) {
                char newgender = gender4.getText().charAt(0);
                try {
                    controller.UpdateGender(newgender, userid);
                    gender2.setText(String.valueOf(newgender));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            gender4.setText("");
        });

        weight3.addActionListener(e -> {
            if (!(weight4.getText().equals(""))) {
                float newweight = Float.parseFloat(weight4.getText());
                try {
                    controller.UpdateWeight(newweight, userid);
                    weight2.setText(String.valueOf(newweight));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            weight4.setText("");
        });

        height3.addActionListener(e -> {
            if (!(height4.getText().equals(""))) {
                float newheight = Float.parseFloat(height4.getText());
                try {
                    controller.UpdateHeight(newheight, userid);
                    height2.setText(String.valueOf(newheight));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            height4.setText("");
        });

        feedback.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(null,
                        controller.GiveFeedback(gateway.getAccounts().get(userid).getHeight(),
                                gateway.getAccounts().get(userid).getWeight(), userid));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        editrecipe.addActionListener(e -> {
            try {
                new RecipeInitialDisplay(userid);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        exit.addActionListener(e -> dispose());

        this.add(main);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

}
