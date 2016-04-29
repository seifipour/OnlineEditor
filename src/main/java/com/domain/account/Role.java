package com.domain.account;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
