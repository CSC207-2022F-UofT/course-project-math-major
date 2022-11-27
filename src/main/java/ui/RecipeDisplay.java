package ui;
//This class is the presenter that visualizes the entity.Recipe. It creates a simple UI that allow users to enter the information
//desired to create a new recipe.

import controller.RecipeController;
import entity.Ingredient;
import entity.Recipe;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RecipeDisplay {

    final int width = 1200;
    final int height = 900;

    RecipeController recipeController = new RecipeController();

    JList<Recipe> recipeList;
    JLabel iLabel;
    JList<Ingredient> ingredientList;

    DefaultListModel<Ingredient> ingredientsListModel;
    JTextArea steps;

    public RecipeDisplay()
    {
        JFrame f = new JFrame("Recipe Application");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack(); // automatically size the frame
        f.setSize(width, height);

        // We create a bottom JPanel to place everything on.
        // This sets the Border Layout to have a horizontal gap of 5
        // and a vertical gap of 10 between each widget.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        f.add(panel);


        // Title
        JLabel title = new JLabel("Recipe & Calories", SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(width, 40));
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        title.setBorder(new EmptyBorder(10, 0,10,0));
        // title.setHorizontalAlignment(0);
        panel.add(title, BorderLayout.PAGE_START); // top


        /** Creation of a Panel to place on the Left (Recipe List) */
        JPanel recipePanel = new JPanel();
        recipePanel.setPreferredSize(new Dimension(width/3, height/2));
        panel.add(recipePanel, BorderLayout.LINE_START);

        // Recipe Label
        JLabel rLabel = new JLabel("Select a recipe", SwingConstants.CENTER);
        rLabel.setPreferredSize(new Dimension(width/3 - 50, 50));
        rLabel.setFont(new Font("Sans Serif", Font.BOLD, 14));
        recipePanel.add(rLabel);

        // Recipe JList
        List<Recipe> recipes = recipeController.getRecipes();
        recipeList = new JList(recipes.toArray());
        recipeList.setFixedCellHeight(30);

        recipeList.setPreferredSize(new Dimension(width/3 - 50, height/2));
        JScrollPane rsp = new JScrollPane(recipeList);
        rsp.setPreferredSize(new Dimension(width/3 - 50, height/2));
        recipePanel.add(rsp);
        // handle selection change event
        recipeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Recipe selectedRecipe = recipeList.getSelectedValue();
                iLabel.setText("Ingredients for " + selectedRecipe.getName());
                ingredientsListModel.clear();
                ingredientsListModel.addAll(selectedRecipe.getIngredients());
                steps.setText(selectedRecipe.getSteps());
            }
        });



        /** Creation of a Panel to place in the Center (Ingredient List) */
        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setPreferredSize(new Dimension(width/3, height/2));
        panel.add(ingredientPanel, BorderLayout.CENTER);

        // Ingredient Label
        iLabel = new JLabel("No Recipe Selected", SwingConstants.CENTER);
        iLabel.setPreferredSize(new Dimension(width/3 - 50, 50));
        iLabel.setFont(new Font("Sans Serif", Font.BOLD, 14));
        ingredientPanel.add(iLabel);

        // Ingredient JList
        ingredientsListModel = new DefaultListModel<>();
        ingredientList = new JList(ingredientsListModel);
        ingredientList.setFixedCellHeight(30);
        ingredientList.setPreferredSize(new Dimension(width/3 - 50, height/2));
        JScrollPane isp = new JScrollPane(ingredientList);
        isp.setPreferredSize(new Dimension(width/3 - 50, height/2));
        ingredientPanel.add(isp);


        /** Creation of a Panel to place on the right (Steps) */
        JPanel StepPanel = new JPanel();
        StepPanel.setPreferredSize(new Dimension(width/3, height/2));
        panel.add(StepPanel, BorderLayout.LINE_END);

        // Step Label
        JLabel sLabel = new JLabel("How to make:", SwingConstants.CENTER);
        sLabel.setPreferredSize(new Dimension(width/3 - 50, 50));
        sLabel.setFont(new Font("Sans Serif", Font.BOLD, 14));
        StepPanel.add(sLabel);

        steps = new JTextArea();
        steps.setPreferredSize(new Dimension(width/3 - 50, height/2));
        steps.setEditable(false);
        StepPanel.add(steps);


        /** Creation of a Panel to place on the bottom (Creation) */
        JButton createRecipeBtn = new JButton("Create Recipe");
        panel.add(createRecipeBtn, BorderLayout.PAGE_END);
        createRecipeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open new Page :)
                new CreateRecipe();
            }
        });

    }

    public static void main(String[] args) {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI. (after everything is loaded)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecipeDisplay();
            }
        });
    }

}