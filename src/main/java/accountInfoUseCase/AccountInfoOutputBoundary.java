package accountInfoUseCase;

public interface AccountInfoOutputBoundary {

    void ShowUserid(String userid);

    void ShowAge(int age);

    void ShowGender(char gender);

    void ShowWeight(float weight);

    void ShowHeight(float height);

    void ShowFeedback(float weight, float height);

}
