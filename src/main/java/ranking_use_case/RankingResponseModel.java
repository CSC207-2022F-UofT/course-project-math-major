package ranking_use_case;

import entity.Rank;

import java.util.List;

public class RankingResponseModel {
    String userid;
    List<Rank> rankList;

    public String getUserid() {
        return userid;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setRankList(List<Rank> rankList) {
        this.rankList = rankList;
    }
}
