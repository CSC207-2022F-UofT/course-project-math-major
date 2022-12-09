package gateway;

import entity.UserAccount;
import java.util.*;
import java.io.*;

/** This is the gateway to store all the UserAccounts and their information. **/

public interface AccountGateway {

    Map<String, UserAccount> getAccounts() throws IOException;

    void saveAccounts(Map<String, UserAccount> accounts) throws IOException;

    boolean addAccount(String userid, String password) throws IOException;

}
