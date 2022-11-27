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
    final int width = 1100;
    final int height = 800;
    public CreateRecipe() {
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
        String column[] = {"Ingredient", "Amount","Units"};
        String data[][] = {{"","",""},{"","",""},{"","",""}};
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




        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecipeController c = new RecipeController();
                ArrayList<String> i = new ArrayList<>();
                ArrayList<String> p = new ArrayList<>();
                ArrayList<Integer> a = new ArrayList<>();
                for (int iterate = 0; iterate <ingre.getModel().getRowCount(); iterate++)
                {

                    i.add((String)(ingre.getModel().getValueAt(iterate, 0)));
                    System.out.println(i);

                    String amt = (String)(ingre.getModel().getValueAt(iterate, 1));
                    if (amt != "")
                    {
                        a.add(Integer.parseInt(amt));
                    }



                    p.add((String)(ingre.getModel().getValueAt(iterate, 2)));
                }
                System.out.println(a);
                if(name.getText() != "")
                {
                    c.createRecipe(name.getText(), i, a, p, s.getText());
                    new RecipeDisplay();
                }
                else {
                    //creates a screen that tells you to enter the information again
                }


            }
        });


    }
}

