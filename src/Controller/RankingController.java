package Controller;

import ranking_recipe_use_case.RankingInputBoundary;

import java.util.ArrayList;

public class RankingController {
    private final RankingInputBoundary rankingInputBoundary;

    public RankingController(RankingInputBoundary rankingInputBoundary) {
        this.rankingInputBoundary = rankingInputBoundary;
    }

    public void rank(ArrayList<Recipe> all_recipes){
        rankingInputBoundary.rank(ArrayList<Recipe>);
    }
}
