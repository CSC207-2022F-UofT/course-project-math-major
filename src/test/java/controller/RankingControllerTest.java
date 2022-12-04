package controller;

import gateway.RatedGateway;
import gateway.RatedGatewayImplementation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import presenter.RankingPresenter;
import ranking_use_case.RankingInteractor;
import ranking_use_case.RankingRequestModel;
import ranking_use_case.RankingResponseModel;
import ui.RankDisplay;

public class RankingControllerTest {
    RankingController rankingController;
    @Before
    public void before(){
        RankingRequestModel rankingRequestModel = new RankingRequestModel("001", null);
        RankDisplay rankDisplay = new RankDisplay();
        RankingPresenter rankingPresenter = new RankingPresenter(rankDisplay);
        RatedGateway ratedGateway = new RatedGatewayImplementation();
        RankingInteractor rankingInteractor = new RankingInteractor(ratedGateway, rankingRequestModel, rankingPresenter);

        rankingController = new RankingController(rankingInteractor);
    }

    @After
    public void after(){
        System.out.println("after");
        rankingController = null;
    }

    @Test
    public void testRank(){
        RankingRequestModel rankingRequestModel = new RankingRequestModel("001", null);
        RankingResponseModel rankingResponseModel = rankingController.rank(rankingRequestModel);
        Assert.assertEquals(rankingResponseModel.getUserid(),"001");
    }
}


