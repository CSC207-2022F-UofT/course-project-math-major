package gateway;

import entity.Rank;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RankGateway {
    Map<String, List<Rank>> getRanks() throws IOException;

    void saveRanks(Map<String, List<Rank>> ranks) throws IOException;

    List<Rank> getRank(String userId);
}
