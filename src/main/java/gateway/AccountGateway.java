package gateway;

import entity.UserAccount;
import java.util.*;
import java.io.*;

public interface AccountGateway {

    Map<String, UserAccount> getAccounts() throws IOException;

    void saveAccounts(Map<String, UserAccount> accounts) throws IOException;

}
