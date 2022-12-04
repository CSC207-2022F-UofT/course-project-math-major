package recipeui;

import controller.RecipeController;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class RecipeDeletion extends JFrame {
    public RecipeDeletion(String userid)
    {
        JFrame f = new JFrame();
        f.setSize(700, 700);
        JLabel n = new JLabel("Enter Name");
        n.setBounds(100, 20, 80, 30);
        JTextField field = new JTextField("");
        field.setBounds(200, 20, 250, 30);

        JButton delete = new JButton("Confirm Delete");
        delete.setBounds(100, 300, 100, 30);

       f.setVisible(true);
       JButton close = new JButton("Close");
       close.setBounds(350, 600, 50, 50);
        f.add(n);
        f.add(field);
       f.add(close);
        f.add(delete);


       close.addActionListener(e ->{
           f.setVisible(false);

       });
        delete.addActionListener(e ->{
            RecipeController c;
            try {
                c = new RecipeController();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            if(Objects.equals(field.getText(), ""))
            {
                new RecipeCreationError();
            }
            else{
                try {
                    c.deleteRecipe(userid, field.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
