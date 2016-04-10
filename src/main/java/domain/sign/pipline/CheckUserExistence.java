package domain.sign.pipline;

import domain.sign.exception.UserExistException;
import persistence.GetConnection;
import com.lambdista.util.Try;

import java.sql.Connection;
import java.sql.ResultSet;

public class CheckUserExistence implements iPipeline {
    private String username;

    public CheckUserExistence(String username){
        this.username = username;
    }
    @Override
    public Try<Boolean> handle() {
        return execute(username);
    }

    private Try<Boolean> execute(String username) {

        Try<Boolean> isUserNotExist = Try.apply(() ->
                {
                    Connection connection = GetConnection.create_connection();
                    ResultSet resultSet = connection.createStatement()
                            .executeQuery("select * from tblUsers where username=" + username);
                    return (resultSet.getFetchSize() == 0);

                }
        );
        return isUserNotExist.flatMap(result -> result
                ? new Try.Success<>(true)
                : new Try.Failure<>(new UserExistException()));

    }
}
