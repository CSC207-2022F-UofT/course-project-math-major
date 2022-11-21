package controller;

import accountInfoUseCase.AccountInfoInputBoundary;

import java.io.IOException;

public class AccountInfoController {

    final AccountInfoInputBoundary aiib;

    public AccountInfoController(AccountInfoInputBoundary aiib) {
        this.aiib = aiib;
    }

    public void UpdatePassword(String password) throws IOException {
        this.aiib.UpdatePassword(password);
    }

    public void UpdateAge(int age) throws IOException {
        this.aiib.UpdateAge(age);
    }

    public void UpdateGender(char gender) throws IOException {
        this.aiib.UpdateGender(gender);
    }

    public void UpdateWeight(float weight) throws IOException {
        this.aiib.UpdateWeight(weight);
    }

    public void UpdateHeight(float height) throws IOException {
        this.aiib.UpdateHeight(height);
    }

    public String GiveFeedback(float height, float weight) {
        return this.aiib.BMIAndFeedback(weight, height);
    }

}
