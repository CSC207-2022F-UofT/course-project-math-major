package presenter;

import ranking_use_case.RankingOutputBoundary;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;
import ui.MainDisplay;
import ui.RankDisplay;

public class RankingPresenter implements RankingOutputBoundary {
    private RankDisplay rankDisplay;
    private MainDisplay mainDisplay;

    public RankingPresenter(MainDisplay mainDisplay) {
        this.mainDisplay = mainDisplay;
    }

    public RankingPresenter(RankDisplay rankDisplay) {
        this.rankDisplay = rankDisplay;
    }

    @Override
    public void showRank(RankingResponseModel rankingResponseModel) {
        rankDisplay.showFrame(rankingResponseModel);
    }

    @Override
    public void showQueryRank(RankingRequestModel rankingRequestModel) {
        mainDisplay.display(rankingRequestModel);
    }
}
