package gateway;

import entity.Rank;
import ranking_use_case.RankingRequestModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingGateway implements IRankingGateway {

    Map<String, java.util.List<Rank>> data = new HashMap<>();

    @Override
    public List<Rank> getRank(String username) throws IOException {
        return data.get(username);
    }

    @Override
    public void save(RankingRequestModel requestModel) {
        data.put(requestModel.getUserId(),requestModel.getRankList());
    }


}
