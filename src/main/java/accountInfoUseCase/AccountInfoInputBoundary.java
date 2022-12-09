package accountInfoUseCase;

import java.io.IOException;

/** This is the input boundary of the AccountInfo System, which receives the command passes by the controller and
 * let the interactor complete the order.**/

public interface AccountInfoInputBoundary {

    void UpdatePassword(String password, String userid) throws IOException;

    void UpdateAge(int age, String userid) throws IOException;

    void UpdateGender(char gender, String userid) throws IOException;

    void UpdateWeight(float weight, String userid) throws IOException;

    void UpdateHeight(float height, String userid) throws IOException;

    String GiveFeedback(float weight, float height, String userid);

}
