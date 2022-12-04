package ranking_recipe_use_case;

import entity.Recipe;
import entity.UserAccount;

import java.util.ArrayList;

public class RankingInteractor implements RankingInputBoundary{
    final UserAccount userAccount;

    public RankingInteractor(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public void rank(ArrayList<Recipe> all_recipes) {

    }

    @Override
    public void display_rank() {

    }
}
