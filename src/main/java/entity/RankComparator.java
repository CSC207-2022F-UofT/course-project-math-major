package entity;

import java.math.BigDecimal;
import java.util.Comparator;

public class RankComparator implements Comparator<Rank> {
    /**
     * This RankComparator class is used for the Collections.sort() method
     * The concrete implementation relies on java.math.BigDecimal
     * It is A design pattern comparator has been used
     * @param r1 The first ranklist
     * @param r2 The details of the rank
     */
    @Override
    public int compare(Rank r1, Rank r2) {
        return new BigDecimal(String.valueOf(r2.getValue())).compareTo(new BigDecimal(String.valueOf(r1.getValue())));
    }
}
