package ranking_use_case;

import entity.Rank;
import entity.RankComparator;
import gateway.RankGateway;

import java.util.Collections;
import java.util.List;

public class RankingInteractor implements RankingInputBoundary {
    private final RankingRequestModel rankingRequestModel;

    private final RankingOutputBoundary rankingOutputBoundary;

    private RankGateway rankGateway;


    public RankingInteractor(RankGateway rankGateway, RankingRequestModel rankingRequestModel, RankingOutputBoundary rankingOutputBoundary) {
        this.rankGateway = rankGateway;
        this.rankingRequestModel = rankingRequestModel;
        this.rankingOutputBoundary = rankingOutputBoundary;
    }

    @Override
    public RankingResponseModel rank(RankingRequestModel requestModel) {
        String userId = requestModel.getUserId();
        List<Rank> rankList = rankGateway.getRank(userId);
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
