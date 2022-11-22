package entity;

import java.math.BigDecimal;
import java.util.Comparator;

public class RankComparator implements Comparator<Rank> {
    @Override
    public int compare(Rank r1, Rank r2) {
        return new BigDecimal(String.valueOf(r2.getValue())).compareTo(new BigDecimal(String.valueOf(r1.getValue())));
    }
}
