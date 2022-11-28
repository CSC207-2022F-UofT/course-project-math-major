package gateway;

import entity.UserAccount;
import java.util.ArrayList;
import java.io.*;

public interface AccountGateway {

    ArrayList<UserAccount> getAccounts() throws IOException;

    void saveAccounts(ArrayList<UserAccount> accounts) throws IOException;

}
