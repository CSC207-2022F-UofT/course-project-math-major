//package Searching_use_case;
//import entity.Recipe;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class SearchingInteractor implements SearchingInputBoundary{
//    final SearchingGateway gateway;
//    final SearchingOutputBoundary presenter;
//
//    /**
//     * Constructor for MessageSearchSearchingInteractor.
//     * @param gateway database to access recipes
//     * @param presenter presenter to let UI know what it should do
//     */
//    public SearchingInteractor(SearchingGateway gateway, SearchingOutputBoundary presenter){
//        this.gateway = gateway;
//        this.presenter = presenter;
//    }
//
//
//    /**
//     * Search for recipes that match requirement and return a SearchingResponse object.
//     * @param data data to match recipes with
//     * @return SearchingResponse object indicating what to show the user
//     */
//    @Override
//    public SearchingResponse search(SearchingData data) {
//        if (data.getRecipeName().isBlank()) {
//            return presenter.prepareFailView("Search query can't be blank");
//        }
//        List<Recipe> recipes = gateway.search(data);
//        List<Map<String, String>> recipeMaps = new ArrayList<>();
//        for (Recipe recipe : recipes) {
//            Map<String, String> recipeMap = new HashMap<>();
//            recipeMap.put("Recipe_calories", String.valueOf(recipe.getCalories()));
//            recipeMap.put("recipe", recipe.getName());
//        }
//
//        if (recipes.isEmpty()) {
//            return presenter.prepareFailView("No Recipes match your query.");
//        }
//        SearchingResponse response = new SearchingResponse(data.getRecipeName(),
//                recipeMaps, true, null);
//        return presenter.prepareSuccessView(response);
//    }
//
//}
