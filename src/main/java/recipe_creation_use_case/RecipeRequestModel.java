package recipe_creation_use_case;
import java.util.ArrayList;
public class RecipeRequestModel {
    private String name;
    private String picture;
    private ArrayList<String> ingredients;
    private ArrayList<Integer> amount;
    private String steps;
    public RecipeRequestModel(String name, String picture, ArrayList<String> ingredients, ArrayList<Integer> amount,String steps)
    {
        this.name = name;
        this.picture = picture;

    }

}
