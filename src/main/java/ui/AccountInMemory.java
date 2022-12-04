package ui;
import account_creation_use_case.AccountDsRequestModel;
import account_creation_use_case.AccountDsGateway;

import java.util.HashMap;
import java.util.Map;

public class AccountInMemory implements AccountDsGateway {

    final private Map<String, AccountDsRequestModel> users = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByUserid(String identifier) {
        return users.containsKey(identifier);
    }


    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(AccountDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getName());
        users.put(requestModel.getName(), requestModel);
    }
}
