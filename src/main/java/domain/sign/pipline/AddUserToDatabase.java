package domain.sign.pipline;

import persistence.GetConnection;
import com.lambdista.util.Try;

import java.sql.Connection;
import java.sql.Statement;

public class AddUserToDatabase implements iPipeline {
    private final String username;
    private final String password;

    public AddUserToDatabase(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Try<Boolean> handle() {
        return execute(username, password);
    }

    private Try<Boolean> execute(String username, String password) {
        return Try.apply(() -> {
            Connection connection = GetConnection.create_connection();
            Statement statement = GetConnection.create_statement(connection);
            statement.executeUpdate("INSERT INTO tblUsers VALUES(" + username + ",'" + password + "')");
            statement.close();
            connection.close();
            return true;
        });
    }
}
