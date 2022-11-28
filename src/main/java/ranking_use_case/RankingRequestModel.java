package ranking_use_case;
import entity.Rank;

import java.util.*;
public class RankingRequestModel {
    private String userId;

    private List<Rank> rankList;

    public String getUserId() {return userId;}

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRankList(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public RankingRequestModel(String userid, List<Rank> rankList) {
        this.rankList = rankList;
        this.userId = userid;
    }
}
