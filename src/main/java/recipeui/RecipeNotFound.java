package recipeui;import javax.swing.*;

//This is the UI that shows up when The user enters an invalid input, it asks the user to input everything again

public class RecipeNotFound {

    public RecipeNotFound()
    {
        JFrame j = new JFrame("Error");
        j.setSize(400, 400);
        j.setVisible(true);
        JLabel l = new JLabel("Recipe not found, enter a correct one");
        j.add(l);
        j.setVisible(true);
    }

}