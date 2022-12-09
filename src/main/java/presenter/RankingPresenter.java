package presenter;

import ranking_use_case.RankingOutputBoundary;
import ranking_use_case.RankingResponseModel;
import ui.MainDisplay;
import ui.RankDisplay;

/**
 * This is the Presenter for the Ranking system
 * It has two generators for two ui (rankDisplay and mainDisplay)
 * It has two method showRank and showQueryRank
 */
public class RankingPresenter implements RankingOutputBoundary {
    private RankDisplay rankDisplay;
    private MainDisplay mainDisplay;

    public RankingPresenter(MainDisplay mainDisplay) {
        this.mainDisplay = mainDisplay;
    }

    public RankingPresenter(RankDisplay rankDisplay) {
        this.rankDisplay = rankDisplay;
    }

    /**
     * This method is to call the rankDisplay to show the rank
     * @param rankingResponseModel A model dedicated to storing user data,
     *                             including the userid and ranklist (rated recipes that are sorted)
     */
    @Override
    public void showRank(RankingResponseModel rankingResponseModel) {
        rankDisplay.showFrame(rankingResponseModel);
    }

    /**
     * This method is used to initialize the components and pass user data to the search userrank portal
     * @param rankingResponseModel A model dedicated to storing user data,
     *      *                             including the userid and ranklist (rated recipes that are sorted)
     */
    @Override
    public void showQueryRank(RankingResponseModel rankingResponseModel) {
        mainDisplay.display(rankingResponseModel);
    }
}
