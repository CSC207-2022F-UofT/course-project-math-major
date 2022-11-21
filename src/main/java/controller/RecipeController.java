package controller;

import entity.Recipe;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;

import java.util.List;

public class RecipeController {

    RecipeGateway gateway = new RecipeGatewayImplementation();

    public List<Recipe> getRecipes() {
        return gateway.getRecipes();
    }

}
