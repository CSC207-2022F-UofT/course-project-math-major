package gateway;

import entity.Ingredient;
import entity.Recipe;
import entity.UserAccount;
import gateway.AccountGateway;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;

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
    public ArrayList<Recipe> getRecipes() throws IOException {

        return recipes;
    }

    //function for adding a recipe, it takes values giving from controller/use cases and then create an entity
    @Override
//The function addRecipe is responsible for
    public void addRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit, String step, String userid) throws IOException {
        AccountGateway ag = new AccountGatewayImplementation();
        Map<String, UserAccount> user = ag.getAccounts();
        UserAccount u = user.get(userid);

        Recipe r = new Recipe(name, 0, step);
        for(int i = 0;i< amount.size(); i++)
        {
            Ingredient ing = new Ingredient(ingre.get(i), amount.get(i),unit.get(i));
            r.addIngredient(ing);

        }
        r.setCalories(calories(ingre, amount));
        recipes.add(r);

        u.setRecipeBook(recipes);
        System.out.println(u.getRecipeBook());
    }
    //Loads the Initial Recipes stored in the dataset
    @Override
    public ArrayList<Recipe> getInitialRecipes(String userid) throws IOException {
        AccountGateway ag = new AccountGatewayImplementation();
        Map<String, UserAccount> user = ag.getAccounts();
        UserAccount u = user.get(userid);
        if (u.getRecipeBook() != null)
        {
            recipes = u.getRecipeBook();
        }
        System.out.println(u.getRecipeBook());
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

        }

        return caloriesCount;
    }

}
