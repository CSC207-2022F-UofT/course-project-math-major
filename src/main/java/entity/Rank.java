package entity;

import java.util.*;

public class Rank {
    private Map<String, Integer> rank;

    public Rank(Map<String, Integer> rank) { this.rank = rank;
    }

    public Map<String, Integer> getRank() {
        return rank;
    }

    public void setRank(Map<String, Integer> rated_rank) {

    // use Map.entrySet(), Convert a Map to a List
    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(rated_rank.entrySet());
    // use Collections.sort() sort the rated_rank
    entryList.sort(new RecipeComparator());
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> e : entryList){
        linkedHashMap.put(e.getKey(), e.getValue());
        }
    rank = linkedHashMap;
    }
}
