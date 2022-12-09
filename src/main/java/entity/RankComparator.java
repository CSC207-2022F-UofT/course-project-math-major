package entity;

import java.math.BigDecimal;
import java.util.Comparator;
/**
 * This RankComparator class is used for the Collections.sort() method
 * It is A design pattern comparator has been used
 */
public class RankComparator implements Comparator<Rank> {
    /**
     * This method is to compare two rated recipes' score
     * The concrete implementation relies on java.math.BigDecimal
     * @param r1 the first Rank to be compared.
     * @param r2 the second Rank to be compared.
     */
    @Override
    public int compare(Rank r1, Rank r2) {
        return new BigDecimal(String.valueOf(r2.getValue())).compareTo(new BigDecimal(String.valueOf(r1.getValue())));
    }
}
