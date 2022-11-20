package ranking_recipe_use_case;

import java.util.Map;

public class RankingInteractor implements RankingInputBoundary {
    private final RankingRequestModel rankingRequestModel;
    private final RankingOutputBoundary rankingOutputBoundary;
    public RankingInteractor(RankingRequestModel rankingRequestModel, RankingOutputBoundary rankingOutputBoundary) {
        this.rankingRequestModel = rankingRequestModel;
        this.rankingOutputBoundary = rankingOutputBoundary;
    }

    @Override
    public void rank(String userid, Map<String, Integer> rated_book) {
        rankingRequestModel.setRecipeBook(rated_book);
        rankingOutputBoundary.showRank(rankingRequestModel.getRecipeBook());
    }
}

