package ranking_recipe_use_case;

import java.util.*;

public class RankingRequestModel {
    private String userid;
    private Map<String, Integer> recipeBook;

    public String getUsername() {
        return userid;
    }

    public RankingRequestModel(Map<String, Integer> recipeBook) { this.recipeBook = recipeBook ;
    }


    public Map<String, Integer> getRecipeBook() {
        return recipeBook;
    }

    public void setRecipeBook(Map<String, Integer> rated_book) {
        this.recipeBook =rated_book;
    }
}
