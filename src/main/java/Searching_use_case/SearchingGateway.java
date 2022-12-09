package gateway;
import entity.Recipe;
import java.util.List;

public interface SearchingGateway {
    /**
     * Searches for recipes in database that match text in data
     * @param searchingData SearchingData object that tells method which recipes to look for
     * @return list of Recipe objects that match data
     */
    List<Recipe> search(SearchingData searchingData);

}
