package businessObjects;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table {

  private List<Row> rows;

  public String getTable() {
    int columnsCount = rows.get(0).rowElement.size();
    int columnsMaxSize[] = new int[columnsCount];

    for (int i = 0; i < rows.size(); i++) {
      for (int b = 0; b < rows.get(i).rowElement.size(); b++) {
        int wordSize = rows.get(i).rowElement.get(b).length();
        if (wordSize > columnsMaxSize[b]) {
          columnsMaxSize[b] = wordSize;
        }
      }
    }
    StringBuilder headAlignFormat = new StringBuilder();
    StringBuilder mainAlignFormat = new StringBuilder();

    for (int i = 0; i < columnsCount; i++) {
      StringBuilder line = new StringBuilder();
      for (int b = 0; b < columnsMaxSize[i]; b++) {
        line.append("-");
      }
      mainAlignFormat.append("|").append("%-").append(columnsMaxSize[i]).append("s");
      headAlignFormat.append("+").append(line);
    }
    mainAlignFormat.append("|");
    headAlignFormat.append("+");
    StringBuilder table = new StringBuilder(headAlignFormat + "\n");
    for (int i = 0; i < rows.size(); i++) {
      String[] row = rows.get(i).rowElement.toArray(new String[rows.get(i).rowElement.size()]);
      table.append(String.format(mainAlignFormat.toString(), row)).append("\n");
      if (i == 0) {
        table.append(headAlignFormat).append("\n");
      }
    }
    table.append(headAlignFormat).append("\n");
    return table.toString();
  }

  @AllArgsConstructor
  @Data
  public static class Row {

    private List<String> rowElement;

  }

}
