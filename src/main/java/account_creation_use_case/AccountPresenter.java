package account_creation_use_case;

public interface AccountPresenter {
    AccountResponseModel prepareSuccessView(AccountResponseModel user);

    AccountResponseModel prepareFailView(String error);
}
