package ranking_use_case;

import entity.Rank;
import entity.RankComparator;

import java.util.Collections;
import java.util.List;

public class RankingInteractor implements RankingInputBoundary {
    private final RankingRequestModel rankingRequestModel;
    private final RankingOutputBoundary rankingOutputBoundary;
    public RankingInteractor(RankingRequestModel rankingRequestModel, RankingOutputBoundary rankingOutputBoundary) {
        this.rankingRequestModel = rankingRequestModel;
        this.rankingOutputBoundary = rankingOutputBoundary;
    }

    @Override
    public RankingResponseModel rank(RankingRequestModel requestModel) {
        List<Rank> rankList = requestModel.getRankList();
        // sort data
        Collections.sort(rankList,new RankComparator());
        RankingResponseModel rankingResponseModel = new RankingResponseModel();
        rankingResponseModel.setUserid(requestModel.getUserId());
        rankingResponseModel.setRankList(rankList);
        return rankingResponseModel;
    }
}

