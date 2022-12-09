package gateway;

import controller.RecipeRatingController;
import entity.Recipe;
import entity.UserAccount;

import java.util.ArrayList;
import java.io.*;
import java.util.Map;

/** This class is the Implementation of the RecipeGateway Interface. It contains functions and
 * interacts with the Recipe Controller
 * and entity of Recipe and Ingredients
 * It contains a calories system which transforms ingredients and their amounts into calories calculated with a large data set.
 * **/
public class RecipeGatewayImplementation implements RecipeGateway {
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
    public void addRecipe(Recipe r, String userid) throws IOException {
        AccountGateway ag = new AccountGatewayImplementation();
        Map<String, UserAccount> user = ag.getAccounts();
        RecipeRatingController c = new RecipeRatingController();
        recipes.add(r);
        user.get(userid).setRecipeBook(recipes);
        ag.saveAccounts(user);
        c.RecipeRatingController(userid);
    }

    @Override
    public void deleteRecipe(String userid, ArrayList<Recipe> recipe) throws IOException {
        AccountGateway ag = new AccountGatewayImplementation();
        Map<String, UserAccount> user = ag.getAccounts();
        RecipeRatingController c = new RecipeRatingController();
        recipes = recipe;
        user.get(userid).setRecipeBook(recipes);
        ag.saveAccounts(user);
        c.RecipeRatingController(userid);
    }

    //Loads the Initial Recipes stored in the dataset
    @Override
    public ArrayList<Recipe> getInitialRecipes(String userid) throws IOException {
        AccountGateway ag = new AccountGatewayImplementation();
        Map<String, UserAccount> user = ag.getAccounts();
        if (user.get(userid).getRecipeBook() != null)
        {
            recipes = user.get(userid).getRecipeBook();
        }
        return recipes;
    }
}
