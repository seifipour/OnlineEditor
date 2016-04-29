package com.domain.account.pipline;

import com.lambdista.util.Try;

public interface iPipelineManager{
    Try<Boolean> execute();
    void register(iPipeline credential);
}
