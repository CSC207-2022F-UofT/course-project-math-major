package controller;
import Searching_use_case.SearchingData;
import Searching_use_case.SearchingInputBoundary;
import Searching_use_case.SearchingResponse;


public class SearchingController {
    final SearchingInputBoundary searchingInput;

    public SearchingController(SearchingInputBoundary searchingInput){
        this.searchingInput = searchingInput;
    }

    public SearchingResponse search(SearchingData data){
        return this.searchingInput.search(data);
    }
}
