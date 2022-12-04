package ui;

import account_creation_use_case.AccountPresenter;
import account_creation_use_case.AccountResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountCreationResponseFormatter implements AccountPresenter {

    @Override
    public AccountResponseModel prepareSuccessView(AccountResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public AccountResponseModel prepareFailView(String error) {
        throw new AccountCreationFailed(error);
    }
}
