/**
 * This class is a gateway to save and get recipe score data from ratedrecipe.csv.
 */
package gateway;

import entity.Rank;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RatedGateway {

    Map<String, Map<String, Double>> getRatedRecipes() throws IOException;

    void saveRatedRecipes(Map<String, Map<String, Double>> rated_recipes) throws IOException;

    List<Rank> getRank(String userId);

}
