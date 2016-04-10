package domain.api;

import domain.sign.exception.InValidCredentialException;
import domain.sign.SignIn;
import domain.sign.SignUp;
import com.lambdista.util.Try;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password) {
        Try<Boolean> status = new SignUp().execute(username, password);

        ResponseEntity responseEntity;
        if (status.isSuccess()) responseEntity = new ResponseEntity(HttpStatus.CREATED);
        else if (status.failed().get() instanceof InValidCredentialException)
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        else responseEntity = new ResponseEntity(HttpStatus.EXPECTATION_FAILED);

        return responseEntity;

    }

    @RequestMapping(value = "sign", method = RequestMethod.GET)
    public ResponseEntity signIn(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password) {
        Try<Boolean> status = new SignIn().execute(username, password);

        ResponseEntity responseEntity;
        if (status.isSuccess()) responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
        else if (status.failed().get() instanceof InValidCredentialException)
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        else responseEntity = new ResponseEntity(HttpStatus.FORBIDDEN);

        return responseEntity;
    }
}