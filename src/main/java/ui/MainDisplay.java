package ui;

import controller.RankingController;
import entity.Rank;
import gateway.InMemoryRankGatewayImpl;
import gateway.RankGateway;
import gateway.RankGatewayImpl;
import presenter.RankingPresenter;
import ranking_use_case.RankingInteractor;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainDisplay extends JFrame{

    private RankGateway rankGateway = null;

    public static void main(String[] args){
        MainDisplay queryDisplay = new MainDisplay();
        queryDisplay.initInMemoryData();
//        queryDisplay.initFileData();
        queryDisplay.display();
    }

    public void display(){
        this.setTitle("query");
        this.setSize(1000,800);
        this.setLayout(null);

        initFrame();

        this.setVisible(true);
    }

    private void initFrame() {
        Font font = new Font("Microsoft JhengHei", Font.BOLD, 26);
        JLabel titleLabel = new JLabel("Community");
        titleLabel.setFont(font);
        titleLabel.setBounds(400,30,200,40);
        this.add(titleLabel);

        JLabel idLabel = new JLabel("userId:");
        idLabel.setBounds(370,150,60,30);
        this.add(idLabel);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(480,150,200,30);
        this.add(jTextField);

        JButton jButton = new JButton("Rank");
        jButton.setBounds(460,300,80,30);
        this.add(jButton);

        jButton.addActionListener(e -> {
            String userId = jTextField.getText();
            if(userId==null||"".equals(userId)){
                JOptionPane.showMessageDialog(this,"please input the userId");
                return;
            }
            else{
                try {
                    List<Rank> rankList = rankGateway.getRank(userId);
                    if(rankList==null||rankList.isEmpty()){
                        JOptionPane.showMessageDialog(this,"can't find the user's data");
                        return;
                    }

                    RankingRequestModel rankingRequestModel = new RankingRequestModel(userId,rankList);
                    RankingPresenter rankingPresenter = new RankingPresenter();
                    RankingInteractor rankingInteractor = new RankingInteractor(rankingRequestModel,rankingPresenter);

                    RankingController rankingController = new RankingController(rankingInteractor);
                    RankingResponseModel rankingResponseModel = rankingController.rank(rankingRequestModel);

                    new RankDisplay(rankingResponseModel);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this,"can't find the user's data");
                    exception.printStackTrace();
                }
            }
        });
    }

    public void initFileData(){
        RankGatewayImpl rankGateway = new RankGatewayImpl();
        this.rankGateway = rankGateway;
    }

    public void initInMemoryData(){
        InMemoryRankGatewayImpl inMemoryRankGateway = new InMemoryRankGatewayImpl();
        this.rankGateway = inMemoryRankGateway;
    }

}
