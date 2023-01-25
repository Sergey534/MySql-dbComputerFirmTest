package utils;

import businessObjects.Table;
import businessObjects.Table.Row;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseUtil {

  public static Table getRequest(String SqlRequest) {
    Table table;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      try (Connection conn = DbAppRequest.getConnection()) {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SqlRequest);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnsName = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
          columnsName[i - 1] = metaData.getColumnName(i);
        }
        List<Table.Row> rowsList = new ArrayList<>();
        List<String> columnsList = Arrays.asList(columnsName);
        rowsList.add(new Row(columnsList));
        while (resultSet.next()) {
          List<String> row = new ArrayList<>();
          for (int i = 0; i < columnsName.length; i++) {
            String value = "";
            try {
              value = resultSet.getObject(columnsName[i]).toString();
            } catch (NullPointerException e) {
              value = "null";
            }
            row.add(value);
          }
          rowsList.add(new Row(row));
        }
        table = new Table(rowsList);
      }
    } catch (Exception ex) {
      MyLogger.info("Connection failed.");
      throw new RuntimeException("exception in getRequest method");
    }
    return table;
  }
}
