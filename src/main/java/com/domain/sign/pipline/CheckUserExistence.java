package com.domain.sign.pipline;

import com.lambdista.util.Try;

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
        return new Try.Success<>(true);
    }
//
//        Try<Boolean> isUserNotExist = Try.apply(() ->
//                {
//                    Connection connection = GetConnection.create_connection();
//                    ResultSet resultSet = connection.createStatement()
//                            .executeQuery("select * from tblUsers where username=" + username);
//                    return (resultSet.getFetchSize() == 0);
//
//                }
//        );
//        return isUserNotExist.flatMap(result -> result
//                ? new Try.Success<>(true)
//                : new Try.Failure<>(new UserExistException()));
//
//    }
}
