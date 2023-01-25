package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAppRequest {

    public static Connection getConnection()  {
        String url = DataManager.getUserData("url");
        String username =  DataManager.getUserData("username");
        String password =  DataManager.getUserData("password");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            MyLogger.info("exception in method getConnection");
            throw  new RuntimeException("connection exception ");

        }
        return connection;
    }
}