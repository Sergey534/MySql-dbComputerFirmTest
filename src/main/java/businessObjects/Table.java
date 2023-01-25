package businessObjects;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table {

  private List<List<String>> rows;

  public void printTable() {
    int columnsCount = rows.get(0).size();
    int columnsMaxSize[] = new int[columnsCount];

    for (int i = 0; i < rows.size(); i++) {
      for (int b = 0; b < rows.get(i).size(); b++) {
        int wordSize = rows.get(i).get(b).length();
        if (wordSize > columnsMaxSize[b]) {
          columnsMaxSize[b] = wordSize;
        }
      }
    }
    String headAlignFormat = "";
    String mainAlignFormat = "";

    for (int i = 0; i < columnsCount; i++) {
      String line = "";
      for (int b = 0; b < columnsMaxSize[i]; b++) {
        line = line + "-";
      }
      mainAlignFormat = mainAlignFormat + "|" + "%-" + columnsMaxSize[i] + "s" + "";
      headAlignFormat = headAlignFormat + "+" + line + "";
    }
    mainAlignFormat = mainAlignFormat + "|";
    headAlignFormat = headAlignFormat + "+";
    System.out.format(headAlignFormat + "%n");
    for (int i = 0; i < rows.size(); i++) {
      String[] row = rows.get(i).toArray(new String[rows.get(i).size()]);
      System.out.format(mainAlignFormat, row);
      System.out.format("%n");
      System.out.format(headAlignFormat + "%n");
    }

  }
}