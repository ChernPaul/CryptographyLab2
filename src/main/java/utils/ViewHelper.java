package utils;

import java.util.List;

public abstract class ViewHelper {

    public static String binViewAsString(boolean[] arrayOfBoolean) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrayOfBoolean.length; i++){
            if (arrayOfBoolean[i]){
                result.append(" 1 ");
            }
            else
                result.append(" 0 ");
        }
        return  result.toString();

    }

    public static String binListViewAsString(List<Boolean> listOfBoolean) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfBoolean.size(); i++)
        {
            if (listOfBoolean.get(i))
            {
                result.append(" 1 ");
            }
            else
                result.append(" 0 ");
        }
        return  result.toString();

    }

}
