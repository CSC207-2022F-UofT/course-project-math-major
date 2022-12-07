package ranking_use_case;
import entity.Rank;

import java.util.List;

/**
 * This class is a packaging of a user output data
 */
public class RankingResponseModel {
    private String userid;
    private List<Rank> rankList;

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
