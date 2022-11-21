package ui;

import entity.Rank;
import ranking_use_case.RankingResponseModel;

import javax.swing.*;
import java.awt.*;

public class RankDisplay extends JFrame {
    public RankDisplay() {
        this.setTitle("rank");
        this.setLayout(null);
        this.setSize(1000,800);
        // initFrame();
    }

    public void showFrame(RankingResponseModel rankingResponseModel) {
        Font font = new Font("Microsoft JhengHei", Font.BOLD, 27);
        JLabel titleLabel = new JLabel("Personal Ranking");
        titleLabel.setFont(font);
        titleLabel.setBounds(350, 30, 300, 40);
        this.add(titleLabel);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBounds(100, 100,800,400);

        JPanel panel = new JPanel();

        int n = rankingResponseModel.getRankList().size();
        panel.setLayout(new GridLayout(n, 3));
        for (int i = 0; i < n; i++) {
            Rank rank = rankingResponseModel.getRankList().get(i);
            JLabel rankLabel = new JLabel(String.valueOf(i+1) + ".");
            panel.add(rankLabel);

            JLabel recpLabel = new JLabel(rank.getName());
            panel.add(recpLabel);

            JLabel scoreLabel = new JLabel(rank.getValue() + "");
            panel.add(scoreLabel);
        }

        jScrollPane.setViewportView(panel);

        this.add(jScrollPane);

        JLabel userLabel = new JLabel("user: " + rankingResponseModel.getUserid());
        userLabel.setBounds(600, 60, 120, 30);
        this.add(userLabel);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(400, 600, 100,30);
        this.add(returnButton);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(400, 600, 100, 30);
        this.add(closeButton);

        returnButton.addActionListener(e -> {
            this.dispose();
        });

        closeButton.addActionListener(e -> {
            System.exit(0);
        });

        this.setVisible(true);
    }
}
