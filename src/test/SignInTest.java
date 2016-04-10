import org.junit.Test;

import java.sql.SQLException;

import domain.sign.exception.InValidCredentialException;
import domain.sign.SignIn;

import static junit.framework.Assert.assertTrue;


public class SignInTest {

    @Test
    public void test_sign_in_should_return_expected_message_for_invalid_username() throws SQLException {
        SignIn signIn = new SignIn();
        String userName = "";
        String password = "Pass";
        assertTrue(signIn.execute(userName, password).failed().get() instanceof InValidCredentialException);
    }

    @Test
    public void test_sign_in_should_return_expected_message_for_invalid_password() throws SQLException {
        SignIn signIn = new SignIn();
        String userName = "user";
        String password = "";
        assertTrue(signIn.execute(userName, password).failed().get() instanceof InValidCredentialException);
    }

    @Test
    public void test_sign_in_should_return_expected_message_for_valid_username() throws SQLException {
        SignIn signIn = new SignIn();
        String valid_user_name = "username";
        String valid_password = "123";
        assertTrue(signIn.execute(valid_user_name, valid_password).isSuccess());
    }
}