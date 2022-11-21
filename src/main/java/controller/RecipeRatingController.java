package Controller;

import RatedUseCase.RatedInteractor;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import gateway.RatedGateway;

import java.io.IOException;

public abstract class RecipeRatingController {
    public void RecipeRatingController(String UserID) throws IOException {
        RatedInteractor ratinginteractor = new RatedInteractor();
        ratinginteractor.RatedInteractor(UserID);
    }
}
