package ranking_recipe_use_case;

import entity.RecipeBook;
import java.util.Map;

public class RankingInteractor implements RankingInputBoundary {
    private final RecipeBook recipeBook;
    private final RankingOutputBoundary rankingOutputBoundary;
    public RankingInteractor(RecipeBook recipeBook, RankingOutputBoundary rankingOutputBoundary) {
        this.recipeBook = recipeBook;
        this.rankingOutputBoundary = rankingOutputBoundary;
    }

    @Override
    public void rank(Map<String, Integer> rated_book) {
        recipeBook.setRecipeBook(rated_book);
        rankingOutputBoundary.showRank(recipeBook.getRecipeBook());
    }
}

