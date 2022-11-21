package ranking_use_case;

import entity.Rank;

import java.util.List;

public interface RankingOutputBoundary {
    RankingResponseModel showRank(RankingResponseModel rankingResponseModel);
}
