package gateway;

import entity.Recipe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface RecipeGateway {

    public List<Recipe> getRecipes() throws IOException;



    void addRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit, String step, String userid) throws IOException;

    public List<Recipe> getInitialRecipes(String userid) throws IOException;

}
