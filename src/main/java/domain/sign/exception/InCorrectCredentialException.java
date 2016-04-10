package domain.sign.exception;

public class InCorrectCredentialException extends Exception{
    InCorrectCredentialException(String message, Throwable throwable){ super(message,throwable);}
    public InCorrectCredentialException(String message){ super(message);}
    public InCorrectCredentialException(){ super("credentials are not correct");}
}
