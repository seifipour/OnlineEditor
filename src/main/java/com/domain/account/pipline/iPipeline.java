package com.domain.account.pipline;

import com.lambdista.util.Try;

public interface iPipeline {
    Try<Boolean> handle();
}
