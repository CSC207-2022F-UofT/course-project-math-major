package ui;

import controller.RecipeController;
import entity.Ingredient;
import entity.Recipe;
import gateway.RecipeGatewayImplementation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateRecipe {
    public CreateRecipe() {
        JFrame f = new JFrame();
        f.setSize(800, 600);
        f.setVisible(true);

        JLabel l = new JLabel("Enter the Recipe Name: ");
        f.add(l);

        JButton confirm = new JButton("Confirm");
        confirm.setSize(40, 40);
        confirm.setLocation(40, 40);
        f.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecipeController c = new RecipeController();
                ArrayList<String> i = new ArrayList<>();
                i.add("Apple");
                ArrayList<String> p = new ArrayList<>();
                p.add("Piece");
                ArrayList<Integer> a = new ArrayList<>();
                a.add(1);

                c.createRecipe("name", i, a, p, "Just do it");
                new RecipeDisplay();
            }
        });


    }
}
