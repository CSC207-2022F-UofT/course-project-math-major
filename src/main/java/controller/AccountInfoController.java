package controller;

import accountInfoUseCase.AccountInfoInputBoundary;

import java.io.IOException;

/** This is the Controller of the AccountInfo System, in order to receive and call the input boundary to follow
 * commands the user made in the UserInfoDisplay UI. **/

public class AccountInfoController {

    final AccountInfoInputBoundary aiib;

    public AccountInfoController(AccountInfoInputBoundary aiib) {
        this.aiib = aiib;
    }

    public void UpdatePassword(String password, String userid) throws IOException {
        this.aiib.UpdatePassword(password, userid);
    }

    public void UpdateAge(int age, String userid) throws IOException {
        this.aiib.UpdateAge(age, userid);
    }

    public void UpdateGender(char gender, String userid) throws IOException {
        this.aiib.UpdateGender(gender, userid);
    }

    public void UpdateWeight(float weight, String userid) throws IOException {
        this.aiib.UpdateWeight(weight, userid);
    }

    public void UpdateHeight(float height, String userid) throws IOException {
        this.aiib.UpdateHeight(height, userid);
    }

    public String GiveFeedback(float height, float weight, String userid) {
        return this.aiib.GiveFeedback(weight, height, userid);
    }
}
