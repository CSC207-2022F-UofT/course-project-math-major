package recipeui;import javax.swing.*;

//This is the UI that shows up when The user enters an invalid input, it asks the user to input everything again

public class RecipeDeleteConfirm {

    public RecipeDeleteConfirm()
    {
        JFrame j = new JFrame("Deleted");
        j.setSize(400, 400);
        j.setVisible(true);
        JLabel l = new JLabel("The recipe you selected is now deleted");
        j.add(l);
        j.setVisible(true);
    }

}