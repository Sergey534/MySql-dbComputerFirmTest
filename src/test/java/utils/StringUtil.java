package utils;

public class StringUtil {

    public static String [] getColumArray(String str){
        return str.split(",");
    }

    public static String addSpaces(String str,int count){
       int  spaceCount=count-str.length();
        String spaces="";
        for(int i=0;i<spaceCount;i++){
            spaces=spaces+" ";
        }
        return str+spaces;
    }

    public static String addBorder(int count){
        String border="";
        for(int i=0;i<count;i++){
          border=border+"—";
        }
        return border;
    }
}
