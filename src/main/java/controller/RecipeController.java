package controller;
import java.util.ArrayList;
import entity.Ingredient;
import entity.Recipe;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;

import java.util.List;

public class RecipeController {

    RecipeGateway gateway = new RecipeGatewayImplementation();

    public List<Recipe> getRecipes() {
        return gateway.getRecipes();
    }

    public void createRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit,
                             String steps)
    {
        gateway.addRecipe(name, ingre, amount, unit, steps);
    }

    public List<Recipe> getInitialRecipes() {
        return gateway.getInitialRecipes();
    }
}
