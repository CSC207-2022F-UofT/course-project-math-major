package Gateway;

import entity.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface RatedGateway {

    Map<String, Map<Recipe, Double>> getRatedRecipes() throws IOException;

    void saveRatedRecipes(Map<String, Map<Recipe, Double>> rated_recipes) throws IOException;

}


