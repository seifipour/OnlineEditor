package domain.sign.pipline;

import com.lambdista.util.Try;

import domain.sign.pipline.iPipeline;

public interface iPipelineManager{
    Try<Boolean> execute();
    void register(iPipeline credential);
}
