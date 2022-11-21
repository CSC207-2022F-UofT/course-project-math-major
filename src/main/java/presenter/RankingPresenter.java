package presenter;

import ranking_use_case.RankingOutputBoundary;
import ranking_use_case.RankingResponseModel;
import ui.RankDisplay;

public class RankingPresenter implements RankingOutputBoundary {
    private RankDisplay rankDisplay;

    public RankingPresenter(RankDisplay rankDisplay) {
        this.rankDisplay = rankDisplay;
    }


    @Override
    public void showRank(RankingResponseModel rankingResponseModel) {
        rankDisplay.showFrame(rankingResponseModel);
    }
}
