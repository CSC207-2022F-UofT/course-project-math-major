package gateway;

import entity.Recipe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface RecipeGateway {

    public List<Recipe> getRecipes();



    void addRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit, String step) throws IOException;

    public List<Recipe> getInitialRecipes();
}
