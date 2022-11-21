package gateway;

import entity.Rank;
import entity.RankFactory;
import ranking_use_case.RankingRequestModel;

import java.io.IOException;
import java.util.*;

public class InMemoryRankGatewayImpl implements RankGateway {

    Map<String, java.util.List<Rank>> ranks = new HashMap<>();

    public InMemoryRankGatewayImpl(){
        loadData();
    }

    private void loadData() {
        InMemoryRankGatewayImpl inMemoryRankGateway = new InMemoryRankGatewayImpl();
        boolean load = false;
        try {
            Map<String, List<Rank>> rankList = inMemoryRankGateway.getRanks();
            if(rankList!=null&&!rankList.isEmpty()){
                load = true;
            }

            for(String key:rankList.keySet()){
                RankingRequestModel rankingRequestModel = new RankingRequestModel(key,rankList.get(key));
                rankingGateway.save(rankingRequestModel);
            }

        } catch (IOException e) {
            System.err.println("can't load data , will init");
//            e.printStackTrace();
        }

        if(load){
            return;
        }

        System.out.println("init Data:");
        Map<String, java.util.List<Rank>> ranks = new HashMap<>();
        java.util.List<Rank> rankList = new ArrayList<>();
        for(int i=0;i<20;i++){
            double rvalue = (double)new Random().nextInt(10000);
            Rank rank = RankFactory.getInstance().createRank("name"+(i+1),rvalue);
            rankList.add(rank);
        }
        ranks.put("memory",rankList);
        System.out.println(ranks);
        try {
            inMemoryRankGateway.saveRanks(ranks);
            RankingRequestModel rankingRequestModel = new RankingRequestModel("memory",rankList);
            rankingGateway.save(rankingRequestModel);
        } catch (IOException e) {
            System.err.println("save ranks error");
//            e.printStackTrace();
        }
    }

    @Override
    public Map<String, List<Rank>> getRanks() throws IOException {
        return ranks;
    }

    @Override
    public void saveRanks(Map<String, List<Rank>> ranks) throws IOException {
        this.ranks = ranks;
    }
}
