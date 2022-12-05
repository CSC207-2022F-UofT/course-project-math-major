package ui;
import account_creation_use_case.AccountDsRequestModel;
import account_creation_use_case.AccountDsGateway;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class FileUser implements AccountDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, AccountDsRequestModel> accounts = new HashMap<>();

    public FileUser(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("creation_time", 2);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String password = String.valueOf(col[headers.get("password")]);
                String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                AccountDsRequestModel user = new AccountDsRequestModel(username, password, ldt);
                accounts.put(username, user);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(AccountDsRequestModel requestModel) {
        accounts.put(requestModel.getName(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (AccountDsRequestModel user : accounts.values()) {
                String line = "%s,%s,%s".formatted(
                        user.getName(), user.getPassword(), user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public boolean existsByUserid(String identifier) {
        return accounts.containsKey(identifier);
    }


}
