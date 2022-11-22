package controller;

import ratedusecase.RatedInteractor;

import java.io.IOException;

public abstract class RecipeRatingController {
    public void RecipeRatingController(String UserID) throws IOException {
        RatedInteractor ratinginteractor = new RatedInteractor();
        ratinginteractor.RatedInteractor(UserID);
    }
}
