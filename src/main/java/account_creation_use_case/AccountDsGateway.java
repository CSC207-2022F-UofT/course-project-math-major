package account_creation_use_case;

public interface AccountDsGateway {
    boolean existsByUserid(String identifier);



    void save(AccountDsRequestModel requestModel);
}
