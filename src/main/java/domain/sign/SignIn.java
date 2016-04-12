package domain.sign;

import com.lambdista.util.Try;
import domain.sign.pipline.CheckCredential;
import domain.sign.pipline.CheckValidInput;
import domain.sign.pipline.PipelineManager;


public class SignIn {

    private PipelineManager pipelineManager;

    public SignIn(PipelineManager pipelineManager) {
        this.pipelineManager = pipelineManager;
    }

    public Try<Boolean> execute(String username, String password) {
        pipelineManager.register(new CheckValidInput(username, password));
        pipelineManager.register(new CheckCredential(username, password));
        return pipelineManager.execute();

    }
}

