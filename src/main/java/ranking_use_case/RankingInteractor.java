package ranking_use_case;

import entity.RankComparator;
import gateway.RankGateway;

import entity.Rank;

import java.util.Collections;
import java.util.List;
public class RankingInteractor implements RankingInputBoundary {
    private final RankingRequestModel rankingRequestModel;

    private final RankingResponseModel rankingResponseModel;

    private RankGateway rankGateway;


    public RankingInteractor(RankingRequestModel rankingRequestModel, RankingResponseModel rankingResponseModel, RankGateway rankGateway) {
        this.rankingRequestModel = rankingRequestModel;
        this.rankingResponseModel = rankingResponseModel;
        this.rankGateway = rankGateway;
    }


    @Override
    public RankingResponseModel rank(RankingRequestModel requestModel) {
        String userId = requestModel.getUseId();
        List<Rank> rankList = rankGateway.getrank(userId);
        //sort data
        if(rankList != null && rankList.isEmpty()) {
            Collections.sort(rankList, new RankComparator());
        }
        RankingResponseModel rankingResponseModel = new RankingResponseModel();
        rankingResponseModel.setUserid(requestModel.getUseId());
        rankingResponseModel.setRankList(rankList);
        return rankingResponseModel;
    }
}
