package com.domain.sign;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    private String id;
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "Account[id=%s, username='%s', password='%s']",
                id, username, password);
    }
}
