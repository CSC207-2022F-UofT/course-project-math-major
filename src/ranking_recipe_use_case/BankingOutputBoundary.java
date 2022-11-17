package ranking_recipe_use_case;

import entity.Rank;

import java.util.Map;

public interface BankingOutputBoundary {
    void showRank(Map<String, Integer> rank);
}
