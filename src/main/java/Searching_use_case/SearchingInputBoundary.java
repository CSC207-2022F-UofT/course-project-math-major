package Searching_use_case;

public interface SearchingInputBoundary {
    /**
     * Search for messages that match query input and return a SearchingResponse object.
     * @param data data to match recipes with
     * @return SearchingResponse object indicating what to show the user
     */
    SearchingResponse search(SearchingData data);
}
