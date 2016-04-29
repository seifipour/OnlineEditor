package com.domain.account.pipline;

import com.persistence.UserRepository;
import com.domain.account.exception.UserExistException;
import com.lambdista.util.Try;

public class CheckUserExistence implements iPipeline {
    private String username;
    private UserRepository userRepository;

    public CheckUserExistence(String username, UserRepository userRepository) {
        this.username = username;
        this.userRepository = userRepository;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username);
    }

    private Try<Boolean> execute(String username) {
        Try<Boolean> isUserNotExist = Try.apply(() ->
                        userRepository.findByUsername(username) ==null
        );
        return isUserNotExist.flatMap(result -> result
                ? new Try.Success<>(true)
                : new Try.Failure<>(new UserExistException()));

    }
}
