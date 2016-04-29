package com.domain.account;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable {

    @Id
    private BigInteger _id;

    private String name;
    private String username;
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private Collection<Role> roles = new HashSet<Role>();

    public User(){}
    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(User user) {
        super();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {return roles;}

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{ username='" + username;
    }
}
