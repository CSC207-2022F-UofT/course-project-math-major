package recipe_rating_use_case;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import entity.Recipe;
import entity.UserAccount;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class RecipeRatingInteracor {

    private double ideal_cal;
    private double interval;
    private double temp_score;
    private double total_cal;

    private String Recipe_name;
    private String RightUserID;

    UserAccount user_account;

    Map<String, Double> recipe_scores = new HashMap<String, Double>();
    Map<String, Map<String, Double>> all_recipe_scores;


    private final AccountGateway gateway = new AccountGatewayImplementation();

    public Map<String, Map<String, Double>> RecipeRatingInteractor(String Userid) throws IOException {
        ArrayList<UserAccount> accounts = gateway.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            UserAccount user_account = accounts.get(i);

            if (user_account.getUserid().equals(Userid)) {
                RightUserID = user_account.getUserid();
                ArrayList<Recipe> user_recipe_book = user_account.getRecipeBook();
                float weight = user_account.getWeight();
                float height = user_account.getHeight();
                char gender = user_account.getGender();
                int age = user_account.getAge();
                if (gender == 'm') {
                    ideal_cal = 66.4730 + 13.7516 * weight + 5.0033 * height - 6.7550 * age;
                } else {
                    ideal_cal = 655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age;
                }
                for (int k = 0; k < user_recipe_book.size(); k++) {
                    Recipe_name = user_recipe_book.get(i).getName();
                    temp_score = 0;
                    total_cal = user_recipe_book.get(i).getCalories();
                    interval = ideal_cal / 5;
                    if (total_cal >= ideal_cal * 2) {
                        temp_score = 1;
                    } else if (total_cal < ideal_cal) {
                        temp_score = total_cal / interval;
                    } else {
                        temp_score = 5 - ((total_cal - ideal_cal) / interval);
                    }
                    recipe_scores.put(user_recipe_book.get(i).getName(), temp_score);
                }
            }
        }
        all_recipe_scores.put(RightUserID, recipe_scores);
        return all_recipe_scores;
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














