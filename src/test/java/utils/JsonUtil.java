package utils;

import businessObjects.Table;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonUtil {

  public static String readJsonFile(String path, String key) {
    Reader reader = null;
    try {
      reader = Files.newBufferedReader(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Gson gson = new Gson();
    Map<?, ?> map = gson.fromJson(reader, Map.class);
    String result = null;
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      if (entry.getKey().equals(key)) {
        result = entry.getValue().toString();
      }
    }
    return result;
  }

  public static Table getTableFromFile(String key) {
    return new Gson().fromJson(DataManager.getTableData(key), Table.class);
  }

}
