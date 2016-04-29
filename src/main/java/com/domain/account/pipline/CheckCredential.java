package com.domain.account.pipline;

import com.persistence.UserRepository;
import com.domain.account.exception.InCorrectCredentialException;
import com.lambdista.util.Try;

public class CheckCredential implements iPipeline {

    private final String username;
    private final String password;
    private UserRepository userRepository;

    public CheckCredential(String username, String password,UserRepository userRepository){
        this.username = username;
        this.password = password;
        this.userRepository = userRepository;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        Try<Boolean> isCorrect = Try.apply(() ->
                        userRepository.findByUsernameAndPassword(username, password).isPresent()
        );
        return isCorrect.flatMap(result -> result ? new Try.Success<>(true) : new Try.Failure<>(new InCorrectCredentialException()));
    }
}
