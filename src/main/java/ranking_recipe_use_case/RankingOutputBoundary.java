package ranking_recipe_use_case;

import java.util.Map;

public interface RankingOutputBoundary {
    void showRank(Map<String, Integer> rank);
}
