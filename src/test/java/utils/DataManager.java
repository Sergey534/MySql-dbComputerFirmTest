package utils;

public class DataManager {

    public static String getRequestData (String key){
        return   JSonReaderUtil.readJsonFile("src/test/java/resources/requestData.json",key);
    }

    public static String getUserData (String key){
        return   JSonReaderUtil.readJsonFile("src/test/java/resources/userData.json",key);
    }

    public static String getColumns(String key){
        return   JSonReaderUtil.readJsonFile("src/test/java/resources/columData.json",key);
    }
}