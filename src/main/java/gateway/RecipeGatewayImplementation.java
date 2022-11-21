package gateway;

import entity.Ingredient;
import entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeGatewayImplementation implements RecipeGateway {

    @Override
    public List<Recipe> getRecipes() {

        String r1_step = "Cook the apple\nPut in the sugar\nfinally poll some water";
        Recipe r1 = new Recipe("Apple Juice", 512, r1_step);
        r1.addIngredient(new Ingredient("Apple", 2, "Entire"));
        r1.addIngredient(new Ingredient("Sugar", 3, "Spoon"));

        Recipe r2 = new Recipe("Banana Bread", 748, "blah blah blah");
        r2.addIngredient(new Ingredient("Banana", 2, "Entire"));
        r2.addIngredient(new Ingredient("Sugar", 3, "Spoon"));
        r2.addIngredient(new Ingredient("Bread", 1, "Piece"));

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(r1);
        recipes.add(r2);
        return recipes;
    }
}
