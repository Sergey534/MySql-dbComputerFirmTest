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
    int[] columnsMaxSize = new int[columnsCount];

    for (Row value : rows) {
      for (int b = 0; b < value.rowElement.size(); b++) {
        int wordSize = value.rowElement.get(b).length();
        if (wordSize > columnsMaxSize[b]) {
          columnsMaxSize[b] = wordSize;
        }
      }
    }
    StringBuilder headAlignFormat = new StringBuilder();
    StringBuilder mainAlignFormat = new StringBuilder();

    for (int i = 0; i < columnsCount; i++) {
      mainAlignFormat.append("|").append("%-").append(columnsMaxSize[i]).append("s");
      headAlignFormat.append("+").append("-".repeat(Math.max(0, columnsMaxSize[i])));
    }
    mainAlignFormat.append("|");
    headAlignFormat.append("+");
    StringBuilder table = new StringBuilder(headAlignFormat + "\n");
    for (int i = 0; i < rows.size(); i++) {
      String[] row = rows.get(i).rowElement.toArray(new String[0]);
      table.append(String.format(mainAlignFormat.toString(), (Object[]) row)).append("\n");
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
