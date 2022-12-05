package ui;

public class AccountCreationFailed  extends RuntimeException {
    public AccountCreationFailed(String error) {
        super(error);
    }
}
