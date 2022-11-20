package entity;

import java.util.*;

public class RecipeBook implements IRecipeBook {
    private String userid;
    private Map<String, Integer> recipebook;

    public String getUsername() {
        return userid;
    }

    public RecipeBook(Map<String, Integer> recipebook) { this.recipebook = recipebook ;
    }

    public Map<String, Integer> getRecipeBook() {
        return recipebook;
    }

    @Override
    public void setRecipeBook(Map<String, Integer> rated_book) {

    // use Map.entrySet(), Convert a Map to a List
    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(rated_book.entrySet());
    // use Collections.sort() sort the rated_rank
    entryList.sort(new RecipeComparator());
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> e : entryList){
        linkedHashMap.put(e.getKey(), e.getValue());
        }
    recipebook = linkedHashMap;
    }
}
