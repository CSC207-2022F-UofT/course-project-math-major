package account_creation_use_case;

public class AccountRequestModel {

    private final String userid;
    private String password;


    public AccountRequestModel(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    String getUserid() {
        return userid;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
