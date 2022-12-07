package gateway;

import entity.Rank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RatedGatewayImplementation implements RatedGateway {

    @Override
    public void saveRatedRecipes(Map<String, Map<String, Double>> rated_recipes) throws IOException {
        FileOutputStream f1  = new FileOutputStream("RatedRecipe.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        o1.writeObject(rated_recipes);
        f1.close();
    }


    @Override
    public Map<String, Map<String, Double>> getRatedRecipes() throws IOException {
        FileInputStream f2 = new FileInputStream("RatedRecipe.csv");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        try {
            Map<String, Map<String, Double>> rated_recipes = (Map<String, Map<String, Double>>) o2.readObject();
            return rated_recipes;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }

    /**
     * This method receives a userId read all
     * It will retrieve the data from RatedRecipe.csv
     * And will add them to the ranklist
     * Finally return the ranklist corresponding to the user in the database
     * @param userId The user's personal identity
     * @return The user's rated recipes in the form of List<Rank>
     */
    @Override
    public List<Rank> getRank(String userId) {
        List<Rank> ranklist = new ArrayList<>();
        try {
            Map<String, Map<String, Double>> recipes = getRatedRecipes();
            if(recipes == null){
                return Collections.emptyList();
            }
            Map<String, Double> rankMap = recipes.get(userId);
            if (rankMap != null){
                for (String key:rankMap.keySet()){
                    Rank rank = new Rank(key, rankMap.get(key));
                    ranklist.add(rank);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranklist;
    }


}
