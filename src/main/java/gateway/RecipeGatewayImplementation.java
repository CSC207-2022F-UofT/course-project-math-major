package gateway;

import entity.Ingredient;
import entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeGatewayImplementation implements RecipeGateway {
    static List<Recipe> recipes = new ArrayList<>();

    @Override
    public List<Recipe> getRecipes() {


        return recipes;
    }


    @Override
    public void addRecipe(String name, ArrayList<String> ingre, ArrayList<Integer> amount, ArrayList<String> unit, String step) {

        Recipe r = new Recipe(name, 200, step);
        for(int i = 0;i< amount.size(); i++)
        {
            Ingredient ing = new Ingredient(ingre.get(i), amount.get(i),unit.get(i));
            r.addIngredient(ing);
        }
        recipes.add(r);
    }

    @Override
    public List<Recipe> getInitialRecipes() {
        String r1_step = "Cook the apple\nPut in the sugar\nfinally poll some water";
        Recipe r1 = new Recipe("Apple Juice", 512, r1_step);
        r1.addIngredient(new Ingredient("Apple", 2, "Entire"));
        r1.addIngredient(new Ingredient("Sugar", 3, "Spoon"));

        Recipe r2 = new Recipe("Banana Bread", 748, "blah blah blah");
        r2.addIngredient(new Ingredient("Banana", 2, "Entire"));
        r2.addIngredient(new Ingredient("Sugar", 3, "Spoon"));
        r2.addIngredient(new Ingredient("Bread", 1, "Piece"));


        if(recipes.contains(r2) == false)
        {
            recipes.add(r2);
        }

        recipes.add(r1);
        return recipes;
    }


}
