package presenter;

import controller.SearchingController;
import Searching_use_case.SearchingInputBoundary;
import Searching_use_case.SearchingOutputBoundary;


import ui.RankDisplay;

public class SearchingPresenter implements SearchingOutputBoundary {
    private SearchDisplay searchDisplay;

    public SearchingPresenter(SearchDisplay searchDisplay) {
        this.searchDisplay = searchDisplay;
    }


    @Override
    public void showSearch(SearchResponseModel SearchingResponseModel) {
        SearchDisplay.showFrame(SearchResponseModel);
    }
}
