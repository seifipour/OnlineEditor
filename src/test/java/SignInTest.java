import com.domain.sign.SignIn;
import com.domain.sign.exception.InValidCredentialException;
import com.domain.sign.pipline.PipelineManager;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;


public class SignInTest {

    @Test
    public void test_sign_in_should_return_expected_message_for_invalid_username() {
        SignIn signIn = new SignIn(new PipelineManager());
        String userName = "";
        String password = "Pass";
        assertTrue(signIn.execute(userName, password).failed().get() instanceof InValidCredentialException);
    }

    @Test
    public void test_sign_in_should_return_expected_message_for_invalid_password() {
        SignIn signIn = new SignIn(new PipelineManager());
        String userName = "user";
        String password = "";
        assertTrue(signIn.execute(userName, password).failed().get() instanceof InValidCredentialException);
    }

//    @Test
//    public void test_sign_in_should_return_expected_message_for_valid_username() {
//        SignIn signIn = new SignIn(new PipelineManager());
//        String valid_user_name = "username";
//        String valid_password = "123";
//        assertTrue(signIn.execute(valid_user_name, valid_password).isSuccess());
//    }
}