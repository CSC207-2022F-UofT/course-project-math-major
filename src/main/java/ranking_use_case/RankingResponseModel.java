package ranking_use_case;

import entity.Rank;

import java.util.List;
import java.util.Map;

public class RankingResponseModel {
    String userid;
    List<Rank> rankList;

    public List<Rank> getRankList() {
        return rankList;
    }

    public void setRankList(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}
