package presenter;

import entity.Rank;
import ranking_use_case.RankingOutputBoundary;
import ranking_use_case.RankingResponseModel;

import java.util.List;

public class RankingPresenter implements RankingOutputBoundary {
    @Override
    public RankingResponseModel showRank(RankingResponseModel rankingResponseModel) {
        return rankingResponseModel;
    }
}
