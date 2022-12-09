package controller;

import ranking_use_case.RankingInputBoundary;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;

/**
 * This class is the Controller for the ranking system
 * It has a generator which has a RankingInputBoundary
 * It also has a rank method to call the rankingInputBoundary to do the sorting operation
 */
public class RankingController {
    final RankingInputBoundary rankingInputBoundary;

    public RankingController(RankingInputBoundary rankingInputBoundary){
        this.rankingInputBoundary = rankingInputBoundary;
    }

    /**
     * This method will call rankingInputBoundary to sort the ranklist in rankingRequestModel
     * @param rankingRequestModel It is a unsorted ranklist of the user
     * @return RankingResponseModel It is a sorted ranklist of the user
     */
    public RankingResponseModel rank(RankingRequestModel rankingRequestModel) {
        return rankingInputBoundary.rank(rankingRequestModel);
    }
}
