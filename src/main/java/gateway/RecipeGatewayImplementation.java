package gateway;

import entity.Ingredient;
import entity.Recipe;
//import entity.UserAccount;
import java.util.ArrayList;
import java.io.*;

/** This class is the Implementation of the RecipeGateway Interface. It contains functions and
 * interacts with the Recipe Controller
 * and entity of Recipe and Ingredients
 * It contains a calories system which transforms ingredients and their amounts into calories calculated with a large data set.
 * **/
public class RecipeGatewayImplementation implements RecipeGateway {
    BufferedReader br = new BufferedReader(new FileReader("calories.csv"));
    String line = "";
    String splitBy = ",";
    int caloriesCount = 0;
    static ArrayList<Recipe> recipes = new ArrayList<>();

    public RecipeGatewayImplementation() throws FileNotFoundException {
    }

    @Override
    public ArrayList<Recipe> getRecipes() {

        return recipes;
    }

    //function for adding a recipe, it takes values giving from controller/use cases and then create an entity
    @Override
//The function addRecipe is responsible for
    public void addRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit, String step) throws IOException {

        Recipe r = new Recipe(name, 0, step);
        for(int i = 0;i< amount.size(); i++)
        {
            Ingredient ing = new Ingredient(ingre.get(i), amount.get(i),unit.get(i));
            r.addIngredient(ing);

        }
        r.setCalories(calories(ingre, amount));
        recipes.add(r);
    }
    //Loads the Initial Recipes stored in the dataset
    @Override
    public ArrayList<Recipe> getInitialRecipes() {
       //Currently hard coded since data gateway is not implemented yet.
        String r1_step = "Cook the apple\nPut in the sugar\nfinally poll some water";
        Recipe r1 = new Recipe("Apple Juice", 512, r1_step);
        r1.addIngredient(new Ingredient("Apple", 2, "Entire"));
        r1.addIngredient(new Ingredient("Sugar", 3, "Spoon"));

        Recipe r2 = new Recipe("Banana Bread", 748, "blah blah blah");
        r2.addIngredient(new Ingredient("Banana", 2, "Entire"));
        r2.addIngredient(new Ingredient("Sugar", 3, "Spoon"));
        r2.addIngredient(new Ingredient("Bread", 1, "Piece"));


        recipes.add(r2);

        recipes.add(r1);
        return recipes;
    }
    //This method quickly calculates the calories with the calories.csv.
    public int calories(ArrayList<String> i, ArrayList<Integer> a) throws IOException {
        while ((line = br.readLine()) != null)
        {
            String[] ing = line.split(splitBy);
            if(i.contains(ing[0]))
            {
                int index = i.indexOf(ing[0]);
                caloriesCount = Integer.parseInt(ing[2]) * a.get(index);
            }
            else {
                caloriesCount += 1;
            }

        }

        return caloriesCount;
    }

}
