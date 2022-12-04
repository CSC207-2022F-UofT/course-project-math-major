package gateway;

import entity.Recipe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface RecipeGateway {

    public List<Recipe> getRecipes() throws IOException;



    void addRecipe(Recipe r, String userid) throws IOException;

    void deleteRecipe(String userid, ArrayList<Recipe> recipes) throws IOException;

    public List<Recipe> getInitialRecipes(String userid) throws IOException;

}

