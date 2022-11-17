package ranking_recipe_use_case;

import entity.Rank;
import java.util.Map;

public class RankingInteractor implements RankingInputBoundary {
    private final Rank rank;
    private final BankingOutputBoundary bankingOutputBoundary;
    public RankingInteractor(Rank rank, BankingOutputBoundary bankingOutputBoundary) {
        this.rank = rank;
        this.bankingOutputBoundary=bankingOutputBoundary;
    }

    @Override
    public void rank(Map<String, Integer> rated_recipes) {
        rank.setRank(rated_recipes);
        bankingOutputBoundary.showRank(rank.getRank());
    }
}

