package Searching_use_case;

public interface SearchingOutputBoundary {

    /**
     * Method called when search was successful.
     * @param response the SearchingOutputBoundary that needs to be mutated and returned
     * @return the mutated SearchingResponse
     */
    SearchingResponse prepareSuccessView(SearchingResponse response);

    /**
     * Method called when search fails.
     * @param error error message that was raised
     * @throws SearchingFailed if search could not be made
     */
    SearchingResponse prepareFailView(String error);
}