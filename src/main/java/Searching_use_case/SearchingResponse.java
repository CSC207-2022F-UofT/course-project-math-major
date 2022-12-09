package Searching_use_case;

import java.util.Map;
import java.util.List;



public class SearchingResponse extends Response {
    private final String requiredRecipe;

    private final List<Map<String, String>> recipesToReturn;



    /**
     * Constructor for MessageSearchResponse.
     * @param requiredRecipe recipe that was searched
     * @param recipesToReturn a Map of the recipes with the key as the userid of the recipe creator and
     *                 the value as the text of the message
     * @param success whether message search was successful
     * @param e exception that was thrown if success is false, null otherwise
     */
    public SearchingResponse(String requiredRecipe, List<Map<String, String>> recipesToReturn, boolean success, Exception e) {
        this.requiredRecipe = requiredRecipe;
        this.recipesToReturn = recipesToReturn;
        this.success = success;
        this.e = e;
    }


    /**
     * Getter method for recipe requirement.
     * @return the requiredRecipe attribute of this SearchingResponse object\
     */
    public String getRequiredRecipe() {
        return this.requiredRecipe;
    }

    /**
     * Getter method for e.
     * @return the e (exception) attribute for this SearchingResponse  object
     */
    public Exception getException() {
        return super.e;
    }

    /**
     * Getter method for RecipesToReturn.
     * @return the RecipesToReturn attribute of this SearchingResponse object\
     */
    public List<Map<String, String>> getRecipesToReturn() {
        return recipesToReturn;
    }
}

