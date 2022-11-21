package entity;

public class RankFactory {
    private static RankFactory rankFactory = new RankFactory();

    private RankFactory(){}

    public Rank createRank(String name, double value) {
        return new Rank(name, value);
    }

    public static RankFactory getInstance() {
        return rankFactory;
    }
}
