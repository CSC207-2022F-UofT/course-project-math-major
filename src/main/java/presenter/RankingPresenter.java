package presenter;

import ranking_use_case.RankingOutputBoundary;

public class RankingPresenter implements RankingOutputBoundary {

    private RankDisplay rankDisplay;

    public RankingPresenter(RankDisplay rankDisplay){
        this.rankDisplay = rankDisplay;
    }

    @Override
    public void showRank(RankingResponseModel rankingResponseModel) {
        rankDisplay.showFrame(rankingResponseModel);
    }
}
