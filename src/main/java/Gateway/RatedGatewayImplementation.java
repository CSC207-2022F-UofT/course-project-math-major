package Gateway;

import entity.Recipe;

import java.io.*;
import java.util.ArrayList;

public class RatedGatewayImplementation implements RatedGateway{
    @Override
    public void saveRatedRecipes(ArrayList<Recipe> rated_recipes) throws IOException {
        FileOutputStream f1  = new FileOutputStream("RatedRecipe.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        o1.writeObject(rated_recipes);
        f1.close();
    }

    @Override
    public ArrayList<Recipe> getRatedRecipes() throws IOException {
        FileInputStream f2 = new FileInputStream("RatedRecipe.csv\"");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        try {
            ArrayList<Recipe> accounts = (ArrayList<Recipe>) o2.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }
}
