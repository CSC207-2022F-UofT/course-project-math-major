package ranking_use_case;

public interface RankingOutputBoundary {
    void showRank(RankingResponseModel rankingResponseModel);

    public void showQueryRank(RankingResponseModel rankingResponseModel);
}
