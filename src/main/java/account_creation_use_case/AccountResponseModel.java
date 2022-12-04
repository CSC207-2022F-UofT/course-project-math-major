package account_creation_use_case;

public class AccountResponseModel {
    String login;
    String creationTime;

    public AccountResponseModel(String login, String creationTime) {
        this.login = login;
        this.creationTime = creationTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
