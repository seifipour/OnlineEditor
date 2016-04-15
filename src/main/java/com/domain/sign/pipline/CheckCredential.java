package com.domain.sign.pipline;

import com.domain.sign.AccountRepository;
import com.domain.sign.exception.InCorrectCredentialException;
import com.lambdista.util.Try;

public class CheckCredential implements iPipeline {

    private final String username;
    private final String password;
    private AccountRepository accountRepository;

    public CheckCredential(String username, String password,AccountRepository accountRepository){
        this.username = username;
        this.password = password;
        this.accountRepository = accountRepository;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        Try<Boolean> isCorrect = Try.apply(() ->
                        accountRepository.findByUsernameAndPassword(username, password).size() > 0
        );
        return isCorrect.flatMap(result -> result ? new Try.Success<>(true) : new Try.Failure<>(new InCorrectCredentialException()));
    }
}
