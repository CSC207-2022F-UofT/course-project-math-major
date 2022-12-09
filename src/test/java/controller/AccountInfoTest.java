package controller;

import accountInfoUseCase.AccountInfoInteractor;
import gateway.AccountGateway;
import gateway.AccountGatewayImplementation;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class AccountInfoTest {

    AccountGateway gateway = new AccountGatewayImplementation();

    @Test
    public void TestUpdateAccountInfo() throws IOException {
        gateway.addAccount("a", "b");
        gateway.addAccount("b", "def");
        gateway.addAccount("c", "asd");
        AccountInfoInteractor interactor = new AccountInfoInteractor(gateway);
        AccountInfoController controller = new AccountInfoController(interactor);
        controller.UpdateAge(32, "a");
        controller.UpdatePassword("qw2e", "b");
        controller.UpdateGender('F', "c");
        controller.UpdateWeight(48.1f, "c");
        controller.UpdateHeight(1.67f, "c");

        assertEquals(32, gateway.getAccounts().get("a").getAge());
        assertEquals("qw2e", gateway.getAccounts().get("b").getPassword());
        assertEquals('F', gateway.getAccounts().get("c").getGender());
        assertEquals(48.1f, gateway.getAccounts().get("c").getWeight());
        assertEquals(1.67f, gateway.getAccounts().get("c").getHeight());
    }

    @Test
    public void TestGenerateFeedback() throws IOException {
        AccountInfoInteractor interactor = new AccountInfoInteractor(gateway);
        AccountInfoController controller = new AccountInfoController(interactor);
        assertEquals("Your current BMI is 17%. You are under weight. Please improve your eating habit!",
                controller.GiveFeedback(gateway.getAccounts().get("c").getHeight(),
                        gateway.getAccounts().get("c").getWeight(), "c"));
    }

}
