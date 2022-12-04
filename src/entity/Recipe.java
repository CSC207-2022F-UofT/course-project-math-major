package entity;

import java.util.ArrayList;
import java.util.Map;
//This class helps the user with the creation of the recipe. It takes the information from the presenter and then
//stores them to create a recipe.
public class Recipe {
    ArrayList<Map<String, Integer>> ingredients;
    String name;
    String picture;
    String steps;

    int calories;
    //The entity.Recipe constructor that initiates the entity.Recipe object.
    public Recipe(String name, String picture, ArrayList<Map<String, Integer>> ingredients, String steps, int calories)
    {
        this.name = name;
        this.picture = picture;
        this.steps = steps;
        this.ingredients = ingredients;
        this.calories = calories;
    }
    //The getter methods for entity.Recipe that returns their element.
    public ArrayList<Map<String, Integer>> getIngredients()
    {
        return ingredients;
    }

    public String getName()
    {
        return name;
    }

    public String getPicture()
    {
        return picture;
    }


}

