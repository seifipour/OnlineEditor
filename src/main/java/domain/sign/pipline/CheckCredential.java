package domain.sign.pipline;

import domain.sign.exception.InCorrectCredentialException;
import persistence.GetConnection;
import com.lambdista.util.Try;

import java.sql.Connection;
import java.sql.ResultSet;

public class CheckCredential implements iPipeline {

    private final String username;
    private final String password;

    public CheckCredential(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        Try<Boolean> isCorrect = Try.apply(() ->
                {
                    Connection connection = GetConnection.create_connection();
                    ResultSet resultSet = connection.createStatement()
                            .executeQuery("select * from tblUsers where username=" + username + " and password=" + password + "");
                    return (resultSet.getFetchSize() > 0);

                }
        );
        return isCorrect.flatMap(result -> result ? new Try.Success<>(true) : new Try.Failure<>(new InCorrectCredentialException()));
    }
}
