package com.domain.account.pipline;

import com.domain.account.User;
import com.persistence.UserRepository;
import com.lambdista.util.Try;

public class AddUserToDatabase implements iPipeline {
    private String name;
    private final String username;
    private final String password;
    private UserRepository userRepository;

    public AddUserToDatabase(String name, String username, String password, UserRepository userRepository){
        this.name = name;
        this.username = username;
        this.password = password;
        this.userRepository = userRepository;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(name,username, password);
    }

    private Try<Boolean> execute(String name, String username, String password) {
        return Try.apply(() -> {
            userRepository.save(new User(name,username,password));
            return true;
        });
    }
}
