package gateway;

import entity.Rank;
import entity.RankFactory;

import java.io.*;
import java.util.*;

public class RankGatewayImpl implements RankGateway {
    private Map<String, List<Rank>> ranks = new HashMap<>();

    public RankGatewayImpl() {
        loadData();
    }

    private void loadData() {
        boolean load = false;
        try {
            Map<String, List<Rank>> rankList = this.getRanks();
            if (rankList != null && rankList.isEmpty()) {
                load = true;
            }
        } catch (IOException e) {
            System.err.println("Cannot load data, will init");
            // e.printStackTrace();
        }

        if (load) {
            return;
        }
        System.out.println("init file Data:");
        Map<String, List<Rank>> ranks = new HashMap<>();
        List<Rank> rankList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            double rvalue = (double) new Random().nextInt(10000);
            Rank rank = RankFactory.getInstance().createRank("name" + (i + 1), rvalue);
            rankList.add(rank);
        }
        ranks.put("admin", rankList);
        System.out.println(ranks);
    }

    @Override
    public Map<String, List<Rank>> getRanks() throws IOException {
        FileInputStream f2 = new FileInputStream("RatedRecipe.csv");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        try {
            Map<String, List<Rank>> ranks = (Map<String, List<Rank>>) o2.readObject();
            this.ranks = ranks;
            return ranks;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }

    @Override
    public void saveRanks(Map<String, List<Rank>> ranks) throws IOException {
        FileOutputStream f1  = new FileOutputStream("RatedRecipe.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        o1.writeObject(ranks);
        f1.close();
    }

    @Override
    public List<Rank> getRank(String userId) {
        return ranks.get(userId);
    }
}

