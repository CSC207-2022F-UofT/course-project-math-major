package controller;

import ranking_use_case.RankingInputBoundary;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;

public class RankingController {
    final RankingInputBoundary rankingInputBoundary;


    public RankingController(RankingInputBoundary rankingInputBoundary) {
        this.rankingInputBoundary = rankingInputBoundary;
    }

    public RankingResponseModel rank(RankingRequestModel rankingRequestModel){
        return rankingInputBoundary.rank(rankingRequestModel);
    }

}
