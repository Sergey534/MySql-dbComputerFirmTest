package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAppRequest {

  private static Connection connection;

  public static Connection getConnection() throws SQLException {
    String url = DataManager.getUserData("url");
    String username = DataManager.getUserData("username");
    String password = DataManager.getUserData("password");

    try {
      connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      MyLogger.error("sql exception in method getConnection");
      throw new SQLException("connection exception ");

    }
    return connection;
  }

  public static void disconnect() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}