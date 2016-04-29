package com.domain.account;

import com.domain.account.exception.InValidCredentialException;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void test_sign_up_should_return_expected_message_for_empty_username(){
        Account account=new Account();
        String emptyUserName = "";
        assertTrue(account.execute("some name",emptyUserName,"some password",null).failed().get()
                instanceof InValidCredentialException);
    }

    @Test
    public void test_sign_up_should_return_expected_message_for_invalid_username(){
        Account account=new Account();
        String emptyUserName = "invalid user name";
        assertTrue(account.execute("some name",emptyUserName,"some password",null).failed().get()
                instanceof InValidCredentialException);
    }

}