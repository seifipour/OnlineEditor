package domain.sign;

import com.lambdista.util.Try;

import domain.sign.pipline.CheckCredential;
import domain.sign.pipline.CheckValidInput;
import domain.sign.pipline.PipelineManager;

public class SignIn {

    public Try<Boolean> execute(String username, String password) {
        PipelineManager filterManager = new PipelineManager();
        filterManager.register(new CheckValidInput(username, password));
        filterManager.register(new CheckCredential(username, password));
        return filterManager.execute();

    }


}

