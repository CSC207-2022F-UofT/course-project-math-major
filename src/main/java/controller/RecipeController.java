package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import entity.Recipe;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;

import java.util.List;
/** This is the Controller of the Recipe functions, in controls the data flow between The presenters and the datasets
 *  **/
public class RecipeController {

    RecipeGateway gateway = new RecipeGatewayImplementation();

    public RecipeController() throws FileNotFoundException {
    }

    public List<Recipe> getRecipes() {
        return gateway.getRecipes();
    }
    //Interacts with the RecipeGateway interface
    public void createRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit,
                             String steps) throws IOException {
        gateway.addRecipe(name, ingre, amount, unit, steps);
    }

    public List<Recipe> getInitialRecipes() {
        return gateway.getInitialRecipes();
    }
}
