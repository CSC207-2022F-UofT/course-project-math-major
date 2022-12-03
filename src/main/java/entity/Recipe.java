package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//This class helps the user with the creation of the recipe. It takes the information from the presenter and then
//stores them to create a recipe.
public class Recipe implements Serializable {
    @Serial
    List<Ingredient> ingredients;
    private String name;
    private String steps;

    private int calories;

    //The entity.Recipe constructor that initiates the entity.Recipe object.
    public Recipe(String name, List<Ingredient> ingredients, String steps)
    {
        this.name = name;
        this.steps = steps;
        this.ingredients = ingredients;
    }

    public Recipe(String name, int calories, String steps) {
        this.name = name;
        this.calories = calories;
        this.steps = steps;
        this.ingredients = new ArrayList<>();
    }

    //The getter methods for entity.Recipe that returns their element.
    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public String getName()
    {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    @Override
    public String toString() {
        return String.format("%s, %d cals", name, calories);
    }
}

