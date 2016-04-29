package com.domain.account.pipline;

import com.domain.account.exception.InValidCredentialException;
import com.lambdista.util.Try;

import java.util.regex.Pattern;

public class CheckValidInput implements iPipeline {

    private String username;
    private String password;

    public CheckValidInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        return Try.apply(() -> pattern.matcher(username).matches() && !username.isEmpty() && !password.isEmpty())
                .flatMap(result -> result ? new Try.Success<>(true) :
                        new Try.Failure<>(new InValidCredentialException()));
    }
}
