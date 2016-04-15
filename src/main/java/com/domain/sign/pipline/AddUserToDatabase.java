package com.domain.sign.pipline;

import com.domain.sign.Account;
import com.domain.sign.AccountRepository;
import com.lambdista.util.Try;

public class AddUserToDatabase implements iPipeline {
    private final String username;
    private final String password;
    private AccountRepository accountRepository;

    public AddUserToDatabase(String username, String password, AccountRepository accountRepository){
        this.username = username;
        this.password = password;
        this.accountRepository = accountRepository;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        return Try.apply(() -> {
            accountRepository.save(new Account(username,password));
            return true;
        });
    }
}
