package ranking_use_case;

import entity.Rank;
import entity.RankComparator;
import gateway.RatedGateway;

import java.util.Collections;
import java.util.List;

public class RankingInteractor implements RankingInputBoundary {
    private final RankingRequestModel rankingRequestModel;

    private final RankingOutputBoundary rankingOutputBoundary;

    private RatedGateway ratedGateway;


    public RankingInteractor(RatedGateway ratedGateway, RankingRequestModel rankingRequestModel, RankingOutputBoundary rankingOutputBoundary) {
        this.ratedGateway = ratedGateway;
        this.rankingRequestModel = rankingRequestModel;
        this.rankingOutputBoundary = rankingOutputBoundary;
    }

    @Override
    public RankingResponseModel rank(RankingRequestModel requestModel) {
        String userId = requestModel.getUserId();
        List<Rank> rankList = ratedGateway.getRank(userId);
        //sort data
        if(rankList != null && !rankList.isEmpty()) {
            Collections.sort(rankList, new RankComparator());
        }
        RankingResponseModel rankingResponseModel = new RankingResponseModel();
        rankingResponseModel.setUserid(requestModel.getUserId());
        rankingResponseModel.setRankList(rankList);
        return rankingResponseModel;
    }
}



