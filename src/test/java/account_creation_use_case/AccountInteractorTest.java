package account_creation_use_case;
import entity.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.AccountInMemory;
import static org.junit.jupiter.api.Assertions.*;

class AccountInteractorTest {
    @Test
    void create() {
        AccountDsGateway userRepository = new AccountInMemory();
        AccountPresenter presenter = new AccountPresenter() {
            @Override
            public AccountResponseModel prepareSuccessView(AccountResponseModel user) {
                assertEquals("helen", user.getLogin());
                assertNotNull(user.getCreationTime()); // any creation time is fine.
                assertTrue(userRepository.existsByUserid("helen"));
                return null;
            }

            @Override
            public AccountResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };
        UserAccount useraccount = new UserAccount("helen", "123456hhh");
        AccountInputBoundary interactor = new AccountInteractor(userRepository, presenter, useraccount);
        AccountRequestModel inputData = new AccountRequestModel("helen", "123456hhh");
        interactor.create(inputData);
    }
}
