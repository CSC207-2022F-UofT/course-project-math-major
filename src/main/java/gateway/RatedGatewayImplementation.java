package gateway;

import entity.Rank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RatedGatewayImplementation implements RatedGateway {

    public void saveRatedRecipes(Map<String, Map<String, Double>> rated_recipes) throws IOException {
        FileOutputStream f1  = new FileOutputStream("RatedRecipe.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        o1.writeObject(rated_recipes);
        f1.close();
    }

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

    public Map<String, Map<String, Double>> getRatedRecipes() throws IOException {
        FileInputStream f2 = new FileInputStream("RatedRecipe.csv");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        try {
            Map<String, Map<String, Double>> accounts = (Map<String, Map<String, Double>>) o2.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }


}
