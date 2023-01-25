package utils;

public class DataManager {

    public static String getRequestData (String key){
        return   JsonReaderUtil.readJsonFile("src/test/java/resources/requestData.json",key);
    }

    public static String getUserData (String key){
        return   JsonReaderUtil.readJsonFile("src/test/java/resources/userData.json",key);
    }

}