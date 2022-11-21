package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRecipe  {
    public CreateRecipe() {
        JFrame f = new JFrame();
        f.setSize(800, 600);
        f.setVisible(true);

        JLabel l = new JLabel("Enter the Recipe Name: ");
        f.add(l);


    }
}
