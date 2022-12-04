package recipeui;

import entity.Ingredient;
import entity.Recipe;
import entity.UserAccount;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import gateway.RecipeGateway;
import gateway.RecipeGatewayImplementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class RecipeUseCase {
    BufferedReader br = new BufferedReader(new FileReader("calories.csv"));
    String line = "";
    String splitBy = ",";
    int caloriesCount = 0;
    RecipeGateway rg = new RecipeGatewayImplementation();
    public RecipeUseCase() throws FileNotFoundException {

    }
    public void deleteRecipe(String name, String userid) throws IOException {
        AccountGateway ag = new AccountGatewayImplementation();
        Map<String, UserAccount> user = ag.getAccounts();
        UserAccount a = user.get(userid);
        int count = 0;
        while(count < a.getRecipeBook().size())
        {

            if(Objects.equals(a.getRecipeBook().get(count).getName(), name))
            {

                a.getRecipeBook().remove(count);
                rg.deleteRecipe(userid, a.getRecipeBook());
                new RecipeDeleteConfirm();


                break;
            }
            count++;
        }
        if (count == a.getRecipeBook().size())
        {
            new RecipeNotFound();
        }
    }

    public void addRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit, String step, String userid) throws IOException {

        Recipe r = new Recipe(name, 0, step);
        for(int i = 0;i< amount.size(); i++)
        {
            Ingredient ing = new Ingredient(ingre.get(i), amount.get(i),unit.get(i));
            r.addIngredient(ing);

        }
        r.setCalories(calories(ingre, amount));
        rg.addRecipe(r, userid);
    }

    public int calories(ArrayList<String> i, ArrayList<Integer> a) throws IOException {

        while ((line = br.readLine()) != null)
        {
            String[] ing = line.split(splitBy);
            if(i.contains(ing[0]))
            {
                int index = i.indexOf(ing[0]);
                caloriesCount = Integer.parseInt(ing[2]) * a.get(index);
            }

        }

        return caloriesCount;
    }

}

