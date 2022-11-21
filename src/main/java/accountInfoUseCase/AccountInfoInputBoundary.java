package accountInfoUseCase;

import java.io.IOException;

public interface AccountInfoInputBoundary {

    void UpdatePassword(String password) throws IOException;

    void UpdateAge(int age) throws IOException;

    void UpdateGender(char gender) throws IOException;

    void UpdateWeight(float weight) throws IOException;

    void UpdateHeight(float height) throws IOException;

    String BMIAndFeedback(float weight, float height);

}
