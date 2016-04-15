package com.domain.sign;

import com.lambdista.util.Try;
import com.domain.sign.pipline.CheckCredential;
import com.domain.sign.pipline.CheckValidInput;
import com.domain.sign.pipline.PipelineManager;


public class SignIn {

    private PipelineManager pipelineManager;

    public SignIn(PipelineManager pipelineManager) {
        this.pipelineManager = pipelineManager;
    }

    public Try<Boolean> execute(String username, String password, AccountRepository accountRepository) {
        pipelineManager.register(new CheckValidInput(username, password));
        pipelineManager.register(new CheckCredential(username, password,accountRepository));
        return pipelineManager.execute();

    }
}

