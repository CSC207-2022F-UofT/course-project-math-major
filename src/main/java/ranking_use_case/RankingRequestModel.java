package ranking_use_case;

import entity.Rank;

import java.util.*;

public class RankingRequestModel {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private List<Rank> rankList;

    public List<Rank> getRankList() {
        return rankList;
    }

    public void setRankList(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public RankingRequestModel(String userId, List<Rank> rankList) {
        this.userId = userId;
        this.rankList = rankList ;
    }


}
