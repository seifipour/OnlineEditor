package com.domain.sign.pipline;

import com.domain.sign.AccountRepository;
import com.domain.sign.exception.UserExistException;
import com.lambdista.util.Try;

public class CheckUserExistence implements iPipeline {
    private String username;
    private AccountRepository accountRepository;

    public CheckUserExistence(String username, AccountRepository accountRepository) {
        this.username = username;
        this.accountRepository = accountRepository;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username);
    }

    private Try<Boolean> execute(String username) {
        Try<Boolean> isUserNotExist = Try.apply(() ->
                        accountRepository.findByUsername(username).size() > 0
        );
        return isUserNotExist.flatMap(result -> result
                ? new Try.Success<>(true)
                : new Try.Failure<>(new UserExistException()));

    }
}
