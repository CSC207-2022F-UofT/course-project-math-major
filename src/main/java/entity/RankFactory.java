package entity;

public class RankFactory {
    private static final RankFactory rankFactory = new RankFactory();
    /**
     * The RankFactory class uses the Factory design pattern,
     * It is only used when the rating systems and the recipe creating system not constructed
     * This class has createRank() and getInstance() method for generating and obtain temporary test instance.
     */
    private RankFactory(){}

    public Rank createRank(String name, double value) {
        return new Rank(name, value);
    }

    public static RankFactory getInstance() {
        return rankFactory;
    }
}
