package gateway;

import entity.Rank;

import java.io.*;
import java.util.List;
import java.util.Map;

public class RankGatewayImpl implements RankGateway {
    @Override
    public void saveRanks(Map<String, List<Rank>> ranks) throws IOException {
        FileOutputStream f1  = new FileOutputStream("RatedRecipe.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        o1.writeObject(ranks);
        f1.close();
    }

    @Override
    public Map<String, List<Rank>> getRanks() throws IOException {
        FileInputStream f2 = new FileInputStream("RatedRecipe.csv");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        try {
            Map<String, List<Rank>> ranks = (Map<String, List<Rank>>) o2.readObject();
            return ranks;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }
}
