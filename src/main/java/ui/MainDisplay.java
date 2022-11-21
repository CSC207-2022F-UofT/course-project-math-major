package ui;

import controller.RankingController;
import entity.Rank;
import entity.RankFactory;
import gateway.InMemoryRankGatewayImpl;
import gateway.RankGatewayImpl;
import gateway.RankingGateway;
import presenter.RankingPresenter;
import ranking_use_case.RankingInteractor;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainDisplay extends JFrame{

    private RankingGateway rankingGateway = new RankingGateway();

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
                    List<Rank> rankList = rankingGateway.getRank(userId);
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
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(this,"can't find the user's data");
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void initFileData(){
        RankGatewayImpl rankGateway = new RankGatewayImpl();
        boolean load = false;
        try {
            Map<String, List<Rank>> rankList = rankGateway.getRanks();
            if(rankList!=null&&!rankList.isEmpty()){
                load = true;
            }

            for(String key:rankList.keySet()){
                RankingRequestModel rankingRequestModel = new RankingRequestModel(key,rankList.get(key));
                rankingGateway.save(rankingRequestModel);
            }

        } catch (IOException e) {
            System.err.println("can't load data , will init");
//            e.printStackTrace();
        }

        if(load){
            return;
        }

        System.out.println("init Data:");
        Map<String, java.util.List<Rank>> ranks = new HashMap<>();
        java.util.List<Rank> rankList = new ArrayList<>();
        for(int i=0;i<20;i++){
            double rvalue = (double)new Random().nextInt(1000);
            Rank rank = RankFactory.getInstance().createRank("recp"+(i+1),rvalue);
            rankList.add(rank);
        }
        ranks.put("admin",rankList);
        System.out.println(ranks);
        try {
            rankGateway.saveRanks(ranks);
            RankingRequestModel rankingRequestModel = new RankingRequestModel("admin",rankList);
            rankingGateway.save(rankingRequestModel);
        } catch (IOException e) {
            System.err.println("save ranks error");
//            e.printStackTrace();
        }
    }

    public void initInMemoryData(){

    }


    public Map<String, java.util.List<Rank>> getData(){
        RankGatewayImpl ratedGatewayImplementation = new RankGatewayImpl();
        Map<String, java.util.List<Rank>> ratedRecipes = new HashMap<>();

        System.out.println("get Data:");
        try {
            ratedRecipes = ratedGatewayImplementation.getRanks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("load data:"+ratedRecipes);
        return ratedRecipes;
    }

}
