package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import entity.Recipe;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;

import java.util.List;

public class RecipeController {

    RecipeGateway gateway = new RecipeGatewayImplementation();

    public RecipeController() throws FileNotFoundException {
    }

    public List<Recipe> getRecipes() throws IOException {
        return gateway.getRecipes();
    }
    //Interacts with the RecipeGateway interface
    public void createRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit,
                             String steps, String userid) throws IOException {
        gateway.addRecipe(name, ingre, amount, unit, steps, userid);
    }

    public List<Recipe> getInitialRecipes(String userid) throws IOException {
        return gateway.getInitialRecipes(userid);
    }
}
