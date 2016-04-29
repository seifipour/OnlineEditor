package com.domain.account.exception;

public class InValidCredentialException extends Exception {
    public InValidCredentialException(String message, Throwable throwable){super(message,throwable);}
    public InValidCredentialException(String message){super(message);}
    public InValidCredentialException(){super("credentials are not valid");}
}
