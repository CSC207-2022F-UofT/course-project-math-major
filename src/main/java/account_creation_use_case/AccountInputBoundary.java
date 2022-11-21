package account_creation_use_case;

public interface AccountInputBoundary {
    AccountResponseModel create(AccountRequestModel requestModel);
}
