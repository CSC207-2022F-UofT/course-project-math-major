package account_creation_use_case;

import entity.UserAccount;

public class AccountInteractor implements AccountInputBoundary{

    final AccountDsGateway accountDsGateway;
    final AccountPresenter accountPresenter;
    final UserAccount useraccount;

    public AccountInteractor(AccountDsGateway accountDfGateway, AccountPresenter accountPresenter,
                             UserAccount useraccount) {
        this.accountDsGateway = accountDfGateway;
        this.accountPresenter = accountPresenter;
        this.useraccount = useraccount;
    }




    @Override
    public AccountResponseModel create(AccountRequestModel requestModel) {

        if (accountDsGateway.existsByUserid(requestModel.getUserid())) {
            return accountPresenter.prepareFailView("This user id already exists.");
        }
/*        UserAccount user = UserAccount.create(requestModel.getid(), requestModel.getPassword());
        AccountDsRequestModel accountDsModel = new AccountDsRequestModel(user.getName(), user.getPassword());
        accountDsGateway.save(accountDsModel);

        AccountResponseModel accountResponseModel = new AccountResponseModel(user.getName());
        return accountPresenter.prepareSuccessView(accountResponseModel);*/
        return null;
    }
}
