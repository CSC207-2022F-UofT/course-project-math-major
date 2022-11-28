package accountInfoUseCase;

import controller.AccountInfoController;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import entity.UserAccount;

import java.io.IOException;
import java.util.ArrayList;

public class AccountInfoInteractor implements AccountInfoInputBoundary {

    private AccountGateway gateway;
    private ArrayList<UserAccount> accounts;

    public AccountInfoInteractor(AccountGateway gateway) throws IOException {
        this.gateway = gateway;
        try{
            accounts = gateway.getAccounts();
        } catch (IOException e) {
            System.out.println("Sorry, there is no account storage!");
        }
    }


    @Override
    public void UpdatePassword(String password, String userid) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(userid)) {
                account.setPassword(password);
                gateway.saveAccounts(accounts);
            }
        }
    }


    @Override
    public void UpdateAge(int age, String userid) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(userid)) {
                account.setAge(age);
                gateway.saveAccounts(accounts);
            }
        }
    }


    @Override
    public void UpdateGender(char gender, String userid) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(userid)) {
                account.setGender(gender);
                gateway.saveAccounts(accounts);
            }
        }
    }


    @Override
    public void UpdateWeight(float weight, String userid) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(userid)) {
                account.setWeight(weight);
                gateway.saveAccounts(accounts);
            }
        }
    }


    @Override
    public void UpdateHeight(float height, String userid) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(userid)) {
                account.setWeight(height);
                gateway.saveAccounts(accounts);
            }
        }
    }


    @Override
    public String GiveFeedback(float weight, float height, String userid) {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(userid)) {
               float bmi = account.getWeight() / (account.getHeight() * account.getHeight());
               if (bmi < 18.5) {
                   return "Your current BMI is " + Math.round(bmi) +
                            "%. You are under weight. Please improve your eating habit!";
               } else if (bmi < 24.9) {
                   return "Your current BMI is " + Math.round(bmi) +
                           "%. You are in normal weight. GOOD JOB!";
               } else if (bmi < 29.9) {
                   return "Your current BMI is " + Math.round(bmi) +
                           "%. You are over weight. Please improve your eating habit!";
               } else if (bmi < 39.9) {
                   return "Your current BMI is " + Math.round(bmi) +
                           "%. You are obese. Please change your diet as soon as possible!";
               }  else {
                   return "Your current BMI is " + Math.round(bmi) +
                           "%. You are extremely obese. Please change your diet as soon as possible!";
               }
            }
        }
        return "N/A";
    }

}
