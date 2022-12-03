package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import entity.Recipe;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;
import ui.AccountLogin;
import ui.AccountRegisterUI;

import java.util.List;

public class RecipeController {

    AccountRegisterUI u = new AccountRegisterUI();
    RecipeGateway gateway = u.getRGateway();


    public RecipeController() throws IOException {
    }

    public List<Recipe> getRecipes() {
        return gateway.getRecipes();
    }
    //Interacts with the RecipeGateway interface
    public void createRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit,
                             String steps) throws IOException {
        gateway.addRecipe(name, ingre, amount, unit, steps);
    }

    public List<Recipe> getInitialRecipes() throws IOException {
        return gateway.getInitialRecipes();
    }
}
