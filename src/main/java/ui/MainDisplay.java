package ui;

import controller.RankingController;
import entity.Rank;
import gateway.RatedGateway;
import gateway.RatedGatewayImplementation;
import presenter.RankingPresenter;
import ranking_use_case.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents the user interface searching different user's rank
 * based on different userID
 */
public class MainDisplay extends JFrame {


    public void display(RankingResponseModel rankingResponseModel) {
        this.setTitle("RankingSystem");
        this.setSize(1000, 800);
        this.setLayout(null);

        initFrame(rankingResponseModel);

        this.setVisible(true);
    }

    /**
     * This method is used for set this user interface's label, text display, button
     * And will add an action which will call showRank() method
     * @param rankingResponseModel A model dedicated to storing user data,
     *                             including the userid and ranklist (rated recipes that are sorted)
     */
    private void initFrame(RankingResponseModel rankingResponseModel) {
        Font font = new Font("Microsoft JhengHei", Font.BOLD, 27);
        JLabel titleLabel = new JLabel("Personal Ranking");
        titleLabel.setFont(font);
        titleLabel.setBounds(350, 30, 300, 40);
        this.add(titleLabel);

        JLabel idLabel = new JLabel("userId:");
        idLabel.setBounds(370, 150, 60, 30);
        this.add(idLabel);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(480, 150, 200, 30);
        jTextField.setText(rankingResponseModel.getUserid());
        this.add(jTextField);

        JButton jButton = new JButton("Rank");
        jButton.setBounds(480, 300, 80, 30);
        this.add(jButton);

        jButton.addActionListener(e -> {
            String userId = jTextField.getText();
            if(userId == null || "".equals(userId)){
                JOptionPane.showMessageDialog(this, "Please input the userId");
                return;
            } else {
                showRank(userId);
            }
        });


    }

    /**
     * This method is based on the clean architecture and show the user's rank
     * @param userId It is the userid attribute in rankingResponseModel
     */
    private void showRank(String userId) {
        try{
            RankingRequestModel rankingRequestModel = new RankingRequestModel(userId, null);

            RankDisplay rankDisplay = new RankDisplay();
            RankingOutputBoundary rankingOutputBoundary = new RankingPresenter(rankDisplay);
            RatedGateway ratedGateway = new RatedGatewayImplementation();
            RankingInputBoundary rankingInputBoundary = new RankingInteractor(ratedGateway, rankingRequestModel, rankingOutputBoundary);

            RankingController rankingController = new RankingController(rankingInputBoundary);
            RankingResponseModel rankingResponseModel = rankingController.rank(rankingRequestModel);

            List<Rank> rankList = rankingResponseModel.getRankList();
            if(rankList == null || rankList.isEmpty()){
                JOptionPane.showMessageDialog(this, "Cannot find the user's data");
                return;
            }
            rankingOutputBoundary.showRank(rankingResponseModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot find user's data");
            e.printStackTrace();
        }
    }




}
