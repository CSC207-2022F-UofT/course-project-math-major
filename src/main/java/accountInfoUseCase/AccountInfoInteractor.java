package accountInfoUseCase;

import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import entity.UserAccount;

import java.io.IOException;
import java.util.ArrayList;

public class AccountInfoInteractor implements AccountInfoInputBoundary{

    private AccountGateway gateway = new AccountGatewayImplementation();
    private ArrayList<UserAccount> accounts;
    private final String userid;

    public AccountInfoInteractor(String userid) throws IOException {
        this.userid = userid;
        try{
            accounts = gateway.getAccounts();
        } catch (IOException e) {
            accounts = new ArrayList<>();
        }
    }

    @Override
    public void UpdatePassword(String password) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(this.userid)) {
                account.setPassword(password);
                gateway.saveAccounts(accounts);
            }
        }
    }

    @Override
    public void UpdateAge(int age) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(this.userid)) {
                account.setAge(age);
                gateway.saveAccounts(accounts);
            }
        }
    }

    @Override
    public void UpdateGender(char gender) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(this.userid)) {
                account.setGender(gender);
                gateway.saveAccounts(accounts);
            }
        }
    }

    @Override
    public void UpdateWeight(float weight) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(this.userid)) {
                account.setWeight(weight);
                gateway.saveAccounts(accounts);
            }
        }
    }

    @Override
    public void UpdateHeight(float height) throws IOException {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(this.userid)) {
                account.setWeight(height);
                gateway.saveAccounts(accounts);
            }
        }
    }

    @Override
    public String BMIAndFeedback(float weight, float height) {
        for (UserAccount account : accounts) {
            if (account.getUserid().equals(this.userid)) {
               float bmi = account.getWeight() / (account.getHeight() * account.getHeight());
               if (bmi < 18.5) {
                   return "Your current BMI is " + bmi +
                            ". You are under weight. Please improve your eating habit!";
               } else if (bmi < 24.9) {
                   return "Your current BMI is " + bmi +
                           ". You are in normal weight. GOOD JOB!";
               } else if (bmi < 29.9) {
                   return "Your current BMI is " + bmi +
                           ". You are over weight. Please improve your eating habit!";
               } else if (bmi < 39.9) {
                   return "Your current BMI is " + bmi +
                           ". You are obese. Please change your diet as soon as possible!";
               }  else {
                   return "Your current BMI is " + bmi +
                           ". You are extremely obese. Please change your diet as soon as possible!";
               }
            }
        }
        return "N/A";
    }

}
