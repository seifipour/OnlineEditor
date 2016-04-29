package com.domain.api;

import com.domain.account.Account;
import com.domain.account.exception.InValidCredentialException;
import com.lambdista.util.Try;
import com.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity account(@RequestBody Map<String,String> user) {
        Try<Boolean> status = new Account().execute(user.get("name"),user.get("username"), user.get("password"), userRepository);

        ResponseEntity responseEntity;
        if (status.isSuccess()) responseEntity = new ResponseEntity(HttpStatus.CREATED);
        else if (status.failed().get() instanceof InValidCredentialException)
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        else responseEntity = new ResponseEntity(HttpStatus.EXPECTATION_FAILED);

        return responseEntity;

    }

}
