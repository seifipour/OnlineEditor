package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GetConnection {

    public static void main(String[] args){
        try{
            // Get connection to Database
            Connection myConn = create_connection();

            // create a statement
            Statement myStem = create_statement(myConn);

            myConn.close();
            myStem.close();
//
//
//            // Execute sql query
//            ResultSet mySet=myStem.executeQuery("select * from tblUsers");
//
//            // process the result set
//
//            while (mySet.next()){
//                System.out.println(mySet.getString("username"));
//                System.out.println(mySet.getString("password"));
//            }

        }
        catch (Exception e){
           e.printStackTrace();
        }
    }

    public static Statement create_statement(Connection myConn) throws SQLException {

        return myConn.createStatement();
    }

    public static Connection create_connection() throws SQLException {

        String url="jdbc:mysql://localhost:3306/dbOnlineEditor?verifyServerCertificate=false&useSSL=false&requireSSL=false";

        Properties properties = new Properties( );
        properties.put( "user", "root" );
        properties.put( "password", "001Lago100" );

        return DriverManager.getConnection(url, properties);
    }


}
