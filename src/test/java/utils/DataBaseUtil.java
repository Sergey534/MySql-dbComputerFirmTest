package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseUtil {

      public static String getRequest(String SqlRequest, String[] columnsName){
            String result = null;
            try{
                  Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                  try (Connection conn = DbAppRequest.getConnection()){
                        Statement statement = conn.createStatement();
                        ResultSet resultSet = statement.executeQuery(SqlRequest);

                        ArrayList<ArrayList<String>> rowList = new ArrayList<>();
                        int[] maxRowSize = new int[columnsName.length];

                        while(resultSet.next()){
                            ArrayList<String> arrayList = new ArrayList<>();
                            for(int i = 0;i < columnsName.length;i++){
                                String value = "";
                                try{
                                    value = "| "+ resultSet.getObject(columnsName[i]).toString()+" | ";
                                }
                                catch (NullPointerException e){
                                    value = "null";
                                }
                                arrayList.add(value);
                                if(maxRowSize[i]<value.length()){
                                    maxRowSize[i]=value.length();
                                }
                            }
                            rowList.add(arrayList);
                        }

                        int maxRow = maxRowSize[maxRowSize.length-1];
                        for(int i = 0;i < columnsName.length;i++){
                            maxRow = maxRow+maxRowSize[i];
                        }

                        String table ="";
                        for(int i = 0;i < columnsName.length;i++){
                            columnsName[i] = StringUtil.addSpaces(columnsName[i],maxRowSize[i]);
                            table = table+columnsName[i];
                        }
                        table = table+"\n";
                        table = table+StringUtil.addBorder(maxRow)+"\n";

                        for(ArrayList<String> rowsList :rowList){
                            for(int i=0;i<columnsName.length;i++){
                                rowsList.set(i,StringUtil.addSpaces(rowsList.get(i),maxRowSize[i]));
                            }
                            for(int i=0;i<columnsName.length;i++){
                                table = table+rowsList.get(i);
                            }
                            table = table+"\n";
                            table = table+StringUtil.addBorder(maxRow)+"\n";
                        }
                        result = table;
                  }
            }
            catch(Exception ex){
                 MyLogger.info("Connection failed.");
                 throw new RuntimeException("exception in getRequest method");
            }
        return result;
      }
}
