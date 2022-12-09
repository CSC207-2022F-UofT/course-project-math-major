package Searching_use_case;

public class SearchingFailed extends RuntimeException {
    /**
     * Constructor for SearchingFailed
     * @param error error message
     */
    public SearchingFailed(String error) {
        super(error);
    }
}

