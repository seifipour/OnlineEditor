package com.domain.sign.pipline;

import com.domain.sign.exception.InValidCredentialException;
import com.lambdista.util.Try;

public class CheckValidInput implements iPipeline {
    private final String username;
    private final String password;

    public CheckValidInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        return Try.apply(() -> !username.isEmpty() && !password.isEmpty())
                .flatMap(result -> result ? new Try.Success<>(true) :
                        new Try.Failure<>(new InValidCredentialException()));
    }
}
