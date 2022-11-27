package accountInfoUseCase;

import java.io.IOException;

public interface AccountInfoInputBoundary {

    void UpdatePassword(String password, String userid) throws IOException;

    void UpdateAge(int age, String userid) throws IOException;

    void UpdateGender(char gender, String userid) throws IOException;

    void UpdateWeight(float weight, String userid) throws IOException;

    void UpdateHeight(float height, String userid) throws IOException;

    String GiveFeedback(float weight, float height, String userid);

}
