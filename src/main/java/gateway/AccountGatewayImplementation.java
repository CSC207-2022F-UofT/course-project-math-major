package gateway;
import entity.UserAccount;
import java.io.*;
import java.util.ArrayList;


public class AccountGatewayImplementation implements AccountGateway{

    @Override
    public void saveAccounts(ArrayList<UserAccount> accounts) throws IOException {
        FileOutputStream f1  = new FileOutputStream("Accounts.csv");
        ObjectOutputStream o1 = new ObjectOutputStream(f1);
        o1.writeObject(accounts);
        f1.close();
    }

    @Override
    public ArrayList<UserAccount> getAccounts() throws IOException {
        FileInputStream f2  = new FileInputStream("Accounts.csv");
        ObjectInputStream o2 = new ObjectInputStream(f2);
        try {
            ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) o2.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f2.close();
        return null;
    }

}
