package gateway;

import java.io.IOException;
import java.util.Map;

public interface IRankingGateway {
    Map<String, Integer> getRank(String username) throws IOException;
    void updateRank() throws IOException;
}
