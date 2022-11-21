package gateway;

import java.io.IOException;
import java.util.Map;

public interface RatedGateway {

    Map<String, Map<String, Double>> getRatedRecipes() throws IOException;

    void saveRatedRecipes(Map<String, Map<String, Double>> rated_recipes) throws IOException;

}
