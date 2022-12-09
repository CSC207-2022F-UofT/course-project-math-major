package gateway;

import entity.UserAccount;

import java.io.*;
import java.util.*;

/** This class implements the methods in AccountGateway, which serve for take all the UserAccounts from the gateway
 * as needed and store thm back. **/

public class AccountGatewayImplementation implements AccountGateway {

    @Override
    public void saveAccounts(Map<String, UserAccount> accounts) throws IOException {
        FileOutputStream f1  = new FileOutputStream("Accounts.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        ArrayList<UserAccount> a = new ArrayList<>(accounts.values());
        o1.writeObject(a);
        f1.close();
    }

    @Override
    public Map<String, UserAccount> getAccounts() throws IOException {
        FileInputStream f2  = new FileInputStream("Accounts.csv");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        Map<String, UserAccount> accounts = new HashMap<>();
        try {
            ArrayList<UserAccount> a = (ArrayList<UserAccount>) o2.readObject();
            for (UserAccount account : a) {
                accounts.put(account.getUserid(), account);
            }
            return accounts;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }

    @Override
    public boolean addAccount(String userid, String password) throws IOException {
        Map<String, UserAccount> accounts;
        try {
            accounts = this.getAccounts();
        } catch (IOException e) {
            accounts = new HashMap<>();
        }
        if (accounts.containsKey(userid)) {
            return false;
        }
        accounts.put(userid, new UserAccount(userid, password));
        this.saveAccounts(accounts);
        return true;
    }
}
