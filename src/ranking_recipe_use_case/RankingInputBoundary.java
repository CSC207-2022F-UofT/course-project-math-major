package ranking_recipe_use_case;

import entity.Recipe;

import java.util.ArrayList;
import java.util.Map;

public interface RankingInputBoundary {
    void rank(Map<String, Integer> rated_recipes);

}
