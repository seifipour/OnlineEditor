import com.domain.sign.AccountRepository;
import com.domain.sign.SignIn;
import com.domain.sign.exception.InValidCredentialException;
import com.domain.sign.pipline.PipelineManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertTrue;


public class SignInTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void test_sign_in_should_return_expected_message_for_invalid_username() {
        SignIn signIn = new SignIn(new PipelineManager());
        String userName = "";
        String password = "Pass";

        assertTrue(signIn.execute(userName, password,accountRepository).failed().get() instanceof InValidCredentialException);
    }

    @Test
    public void test_sign_in_should_return_expected_message_for_invalid_password() {
        SignIn signIn = new SignIn(new PipelineManager());
        String userName = "user";
        String password = "";
        assertTrue(signIn.execute(userName, password,accountRepository).failed().get() instanceof InValidCredentialException);
    }

    @Test
    public void test_sign_in_should_return_expected_message_for_valid_username() {
        SignIn signIn = new SignIn(new PipelineManager());
        String valid_user_name = "username";
        String valid_password = "123";
        assertTrue(signIn.execute(valid_user_name, valid_password,accountRepository).isSuccess());
    }
}