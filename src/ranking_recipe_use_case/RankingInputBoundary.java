package ranking_recipe_use_case;

import entity.Recipe;

import java.util.ArrayList;

public interface RankingInputBoundary {
    void rank(ArrayList<Recipe> all_recipes);

    void display_rank();

}
