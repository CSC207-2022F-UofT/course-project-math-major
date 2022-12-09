package Searching_use_case;


public class SearchingData {
    private final String recipeName;

    /**
     * Constructor for MessageSearchData.
     *
     * @param recipeName   the recipe to be searched
     */
    public SearchingData(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Getter method for recipe name.
     * @return recipe name attribute for this SearchingData object.
     */
    public String getRecipeName() {
        return recipeName;
    }


}

