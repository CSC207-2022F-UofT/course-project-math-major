package ui;

import entity.Ingredient;
import entity.Recipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateReci {



    private JPanel panel1;
    private JTextField textField1;
    private JButton create_button;

    public CreateReci() {
        JFrame f = new JFrame();
        f.setSize(800, 600);
        f.setVisible(true);
        JLabel j = new JLabel("Enter the name");
        f.add(j);
        f.add(create_button);
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recipe r3 = new Recipe("Aguagu", 512, "Science Mr.White");
                r3.addIngredient(new Ingredient("M", 2, "Entire"));

            }
        });
    }

    public static void main(String[] args)
    {
       new CreateReci();
    }
}
