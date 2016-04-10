package domain.sign;


import com.lambdista.util.Try;

import domain.sign.pipline.AddUserToDatabase;
import domain.sign.pipline.CheckUserExistence;
import domain.sign.pipline.CheckValidInput;
import domain.sign.pipline.PipelineManager;

public class SignUp {

    public Try<Boolean> execute(String username, String password) {

        PipelineManager pipelineManager = new PipelineManager();
        pipelineManager.register(new CheckValidInput(username,password));
        pipelineManager.register(new CheckUserExistence(username));
        pipelineManager.register(new AddUserToDatabase(username,password));

        return pipelineManager.execute();

    }


}
