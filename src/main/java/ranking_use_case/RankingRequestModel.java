package ranking_use_case;
import entity.Rank;

/**
 * This class is a packaging of a user input data
 */

import java.util.*;
public class RankingRequestModel {
    private String userId;

    private List<Rank> rankList;

    public String getUserId() {return userId;}

    public RankingRequestModel(String userid, List<Rank> rankList) {
        this.rankList = rankList;
        this.userId = userid;
    }
}
