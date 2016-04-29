package com.domain.account.exception;

public class UserExistException extends Exception {
    public UserExistException(String message){ super(message);}
    public UserExistException(){ super("user already exist");}
}
