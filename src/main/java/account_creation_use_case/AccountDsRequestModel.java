package account_creation_use_case;

public class AccountDsRequestModel {
    private final String userid;
    private String password;

    public AccountDsRequestModel(String userid, String password) {
        this.userid = userid;
        this.password = password;

    }

    public String getName() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
