package ratedusecase;

import gateway.*;
import entity.Recipe;
import entity.UserAccount;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.abs;


public class RatedInteractor {
    private double ideal_cal;
    private double ideal_cal_daily;

    private double interval;
    private double temp_score;
    private double total_cal;

    Map<String, Double> recipe_scores = new HashMap<String, Double>();
    Map<String, Map<String, Double>> all_recipe_scores;

    private final AccountGateway accgateway = new AccountGatewayImplementation();
    private final RecipeGateway recipegateway = new RecipeGatewayImplementation();
    private final RatedGateway ratedgateway = new RatedGatewayImplementation();

    public RatedInteractor() throws FileNotFoundException {
    }


    public Map<String, Double> RateUser_AllRecipe (String Userid) throws IOException {
        Map<String, UserAccount> account_map = accgateway.getAccounts();
        UserAccount user_account = account_map.get(Userid);
        ArrayList<Recipe> user_recipes = (ArrayList<Recipe>) recipegateway.getRecipes();
        float weight = user_account.getWeight();
        float height = user_account.getHeight();
        char gender = user_account.getGender();
        int age = user_account.getAge();
        if (gender == 'm'|| gender == 'M') {
            ideal_cal_daily = 66.4730 + 13.7516 * weight + 5.0033 * height * 100 - 6.7550 * age;
            ideal_cal = ideal_cal_daily/3;
        } else {
            ideal_cal_daily = 655.0955 + 9.5634 * weight + 1.8496 * height * 100 - 4.6756 * age;
            ideal_cal = ideal_cal_daily/3;
        }
        for (int i = 0; i < user_recipes.size(); i++) {
            String Recipe_name = user_recipes.get(i).getName();
            temp_score = 0;
            total_cal = user_recipes.get(i).getCalories();
            interval = ideal_cal / 5;
            if (total_cal >= ideal_cal * 2) {
                temp_score = 0;
            } else if (total_cal < ideal_cal) {
                temp_score = total_cal / interval;
            } else {
                temp_score = 5 - ((total_cal - ideal_cal) / interval);
                if (temp_score < 0){
                    temp_score = 0;
                }
            }
            recipe_scores.put(Recipe_name, temp_score);
        }
        return recipe_scores;
    }

    public void RatedInteractor(String UserID) throws IOException {
        Map<String, Double> NewlyRated_Recipes = this.RateUser_AllRecipe(UserID);
        all_recipe_scores = ratedgateway.getRatedRecipes();
        if (all_recipe_scores.containsKey(UserID)){
            all_recipe_scores.replace(UserID, NewlyRated_Recipes);
        }
        else {
            all_recipe_scores.put(UserID, NewlyRated_Recipes);
        }
        ratedgateway.saveRatedRecipes(all_recipe_scores);
    }
}

            /*
            Universal Ranking:
            String temp_green_type = "vegetable or fruits";
            String temp_protein_type = "protein";
            String temp_grain_type = "grain";
            double total_green;
            double total_grain;
            double total_protein;
            Plate rating:
            half vegetable + fruits, a quarter protein and a quarter grain.
            total_green = 0.0;
            total_grain = 0.0;
            total_protein = 0.0;
            for (Recipe recipe_temp : recipe_book1) {
                Map<String, Integer> temp_ingredients = recipe_temp.getIngredients();
                for (Map.Entry<String, Integer> entry : temp_ingredients.entrySet()) {
                    if (entry.getKey().equals(temp_green_type)){
                        total_green = total_green + entry.getValue();
                    }
                    if (entry.getKey().equals(temp_protein_type)){
                        total_protein = total_protein + entry.getValue();
                    }
                    else {
                        total_grain = total_grain + entry.getValue();
                    }
                }
                double temp_total = total_protein + total_grain + total_green;
                if (total_protein != 0){
                    total_protein = total_protein/temp_total;
                }
                if (total_grain != 0){
                    total_grain = total_grain/temp_total;
                }
                if (total_green != 0){
                    total_green = total_green/temp_total;
                }
                double green_variance = abs(total_green - 0.5);
                double grain_variance = abs(total_grain - 0.25);
                double protein_variance = abs(total_protein - 0.25);
                double total_variance = green_variance + grain_variance + protein_variance;
                double final_score = 10 - 6.66 * total_variance;
                recipe_scores.put(Recipe, final_score);
                }
             */
            /*
            Calories Rating:
            */
            /*
            men: 66.4730 + 13.7516 x weight in kg + 5.0033 x height in cm – 6.7550 x age in years
            women: 655.0955 + 9.5634 x weight in kg + 1.8496 x height in cm – 4.6756 x age in years
            */


