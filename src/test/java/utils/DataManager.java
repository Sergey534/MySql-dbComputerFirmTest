package utils;

public class DataManager {

  public static String getRequestData(String key) {
    return JsonUtil.readJsonFile("src/test/java/resources/requestData.json", key);
  }

  public static String getTableData(String key) {
    return JsonUtil.readJsonFile("src/test/java/resources/tableData.json", key);
  }

  public static String getUserData(String key) {
    return JsonUtil.readJsonFile("src/test/java/resources/userData.json", key);
  }

}