package com.domain.sign;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUsernameAndPassword(String username, String password);
    List<Account> findByUsername(String username);
}
