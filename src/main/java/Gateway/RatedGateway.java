package Gateway;

import entity.Recipe;

import java.io.IOException;
import java.util.ArrayList;

public interface RatedGateway {

    ArrayList<Recipe> getRatedRecipes() throws IOException;

    void saveRatedRecipes(ArrayList<Recipe> rated_recipes) throws IOException;

}


