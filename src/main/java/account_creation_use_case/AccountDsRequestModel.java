package account_creation_use_case;
import java.time.LocalDateTime;
public class AccountDsRequestModel {
    private final String userid;
    private String password;
    private final LocalDateTime creationTime;
    public AccountDsRequestModel(String userid, String password, LocalDateTime creationTime) {
        this.userid = userid;
        this.password = password;
        this.creationTime = creationTime;

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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

}
