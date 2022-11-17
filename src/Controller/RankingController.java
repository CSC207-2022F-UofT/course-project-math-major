package Controller;

import ranking_recipe_use_case.RankingInputBoundary;
import java.util.Map;

public class RankingController {
    final RankingInputBoundary rankingInputBoundary;


    public RankingController(RankingInputBoundary rankingInputBoundary) {
        this.rankingInputBoundary = rankingInputBoundary;
    }

    public void rank(Map<String, Integer> rated_recipes){
        rankingInputBoundary.rank(rated_recipes);
    }

}
