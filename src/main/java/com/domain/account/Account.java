package com.domain.account;


import com.persistence.UserRepository;
import com.lambdista.util.Try;

import com.domain.account.pipline.AddUserToDatabase;
import com.domain.account.pipline.CheckUserExistence;
import com.domain.account.pipline.CheckValidInput;
import com.domain.account.pipline.PipelineManager;

public class Account {

    public Try<Boolean> execute(String name, String username, String password, UserRepository userRepository) {

        PipelineManager pipelineManager = new PipelineManager();
        pipelineManager.register(new CheckValidInput(username,password));
        pipelineManager.register(new CheckUserExistence(username, userRepository));
        pipelineManager.register(new AddUserToDatabase(name,username,password, userRepository));

        return pipelineManager.execute();

    }


}
