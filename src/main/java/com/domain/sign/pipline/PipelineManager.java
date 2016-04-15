package com.domain.sign.pipline;

import com.lambdista.util.Try;

import java.util.ArrayList;
import java.util.List;

public class PipelineManager implements iPipelineManager{
    List<iPipeline> credentialList = new ArrayList<>();

    public Try<Boolean> execute(){
        Try<Boolean> result = new Try.Success<>(true);
        for(iPipeline credential:credentialList){
            result = credential.handle();
            if(result.isFailure()) return new Try.Failure<>(result.failed().get());
        }
        return result;
    }

    public void register(iPipeline credential){
        credentialList.add(credential);
    }
}

