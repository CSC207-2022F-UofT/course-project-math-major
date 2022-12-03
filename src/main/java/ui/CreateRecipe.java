package ui;
//This is the UI presenter of the Recipe book where it creates a recipe. This UI should show up once the users
//click on Create button on their recipe book. It takes in values entered by the user and convert send them to the controller
import controller.RecipeController;


import javax.swing.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CreateRecipe {
    final int width = 1100;
    final int height = 800;
    public CreateRecipe(String userid) {
        JFrame f = new JFrame();
        f.setSize(width, height);
        f.setVisible(true);
        JLabel l = new JLabel("");
        l.setBounds(1000, 350, width/3, 700);
        JTextArea s = new JTextArea("");
        JLabel step = new JLabel("Enter the steps for making");
        step.setBounds(800, 10, 200, 100);
        s.setBounds(700, 100, width/3 - 50, 600);
        JButton confirm = new JButton("Confirm");
        confirm.setBounds(width/2 -40, 700, 80, 40);

        JLabel nameIcon = new JLabel("Enter the Name of the Recipe");
        nameIcon.setBounds(300, 10, 200, 30);

        JTextField name = new JTextField("");
        name.setBounds(300, 40, 300, 30);


        JLabel ingredientIcon = new JLabel("Enter the Ingredients, the amounts, and the unit for amounts");

        ingredientIcon.setBounds(100, 40, 400, 100);
        String[] column = {"Ingredient", "Amount","Units"};
        String[][] data = {{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""}};
        JTable ingre = new JTable(data, column);
        ingre.setRowHeight(20);
        ingre.setBounds(200, 100, width/3 - 50, 600);

        f.add(ingre);
        f.add(ingredientIcon);
        f.add(name);
        f.add(nameIcon);
        f.add(step);
        f.add(confirm);
        f.add(s);
        f.add(l);




        confirm.addActionListener(e -> {
            RecipeController c;
            try {
                c = new RecipeController();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ArrayList<String> i = new ArrayList<>();
            ArrayList<String> p = new ArrayList<>();
            ArrayList<Integer> a = new ArrayList<>();
            for (int iterate = 0; iterate <ingre.getModel().getRowCount(); iterate++)
            {

                i.add((String)(ingre.getModel().getValueAt(iterate, 0)));
                System.out.println(i);

                String amt = (String)(ingre.getModel().getValueAt(iterate, 1));
                if (!Objects.equals(amt, ""))
                {
                    a.add(Integer.parseInt(amt));
                }

                p.add((String)(ingre.getModel().getValueAt(iterate, 2)));
            }
            System.out.println(a);
            if(!Objects.equals(name.getText(), ""))
            {
                try {
                    c.createRecipe(name.getText(), i, a, p, s.getText(), userid);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    new RecipeDisplay(userid);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                f.setVisible(false);
            }
            else {
                //creates a screen that tells you to enter the information again
                new RecipeCreationError();

            }


        });


    }
}

