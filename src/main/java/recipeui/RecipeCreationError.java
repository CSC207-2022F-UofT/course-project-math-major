package recipeui;import javax.swing.*;

//This is the UI that shows up when The user enters an invalid input, it asks the user to input everything again

public class RecipeCreationError {

    public RecipeCreationError()
    {
        JFrame j = new JFrame("Error");
        j.setSize(400, 400);
        j.setVisible(true);
        JLabel l = new JLabel("Please enter an non empty Name");
        j.add(l);
        j.setVisible(true);
    }

}
