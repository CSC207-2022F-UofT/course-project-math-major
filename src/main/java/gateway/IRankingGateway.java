package gateway;

import entity.Rank;
import ranking_use_case.RankingRequestModel;

import java.io.IOException;
import java.util.List;

public interface IRankingGateway {
    List<Rank> getRank(String username) throws IOException;
    void save(RankingRequestModel requestModel);
}
