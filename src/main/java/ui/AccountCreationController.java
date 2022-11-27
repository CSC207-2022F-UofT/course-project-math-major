package ui;
import account_creation_use_case.AccountInputBoundary;
import account_creation_use_case.AccountRequestModel;
import account_creation_use_case.AccountResponseModel;
public class AccountCreationController {
    final AccountInputBoundary userInput;

    public AccountCreationController(AccountInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    AccountResponseModel create(String userid, String password) {
        AccountRequestModel requestModel = new AccountRequestModel(userid, password);

        return userInput.create(requestModel);
    }
}

