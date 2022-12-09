package ui;

import controller.SearchingController;
import Searching_use_case.SearchingData;
import Searching_use_case.SearchingResponse ;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class SearchingDisplay extends JPanel implements ActionListener{
    TextField searchText = new TextField("Search Recipes...");
    SearchingController searchingController;
    int userid;

    public SearchingDisplay() {
        this.searchingController = searchingController;
        this.userid = userid;

        searchText.setColumns(30);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(searchText);
        this.add(searchButton);
    }


    public void actionPerformed() {
        actionPerformed(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchingData data = new SearchingData(searchText.getText());

        try {
            SearchingResponse response = this.searchingController.search(data);
            List<Map<String, String>> recipes = response.getRecipesToReturn();
            JFrame application = new JFrame("Application");
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            JTextArea messagesBox = new JTextArea();
            messagesBox.setEditable(false);
            messagesBox.setFont(new Font("Serif", Font.PLAIN, 15));
            messagesBox.setLineWrap(true);

            for (Map<String, String> recipe : recipes) {
                messagesBox.append("<" + recipe.get("recipe") + ">: " + recipe.get("calories") + "\n");
            }

            mainPanel.add(new JScrollPane(messagesBox), BorderLayout.CENTER);
            application.add(mainPanel);

            application.pack();

            application.setVisible(true);


        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

    }
}
