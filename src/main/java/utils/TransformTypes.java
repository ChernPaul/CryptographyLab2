package utils;

import java.util.ArrayList;
import java.util.List;

public abstract class TransformTypes {



    public static boolean[] listToBooleanArray(List<Boolean> list){

        boolean[] booleanArray = new boolean[list.size()];

        for(int i=0; i < list.size(); i ++){
            booleanArray[i] = list.get(i);
        }
        return booleanArray;

    }

    public static List<Boolean> arrayToBooleanList(boolean[] array){

        List<Boolean> booleanList = new ArrayList<Boolean>();

        for(int i=0; i < array.length; i ++){
            booleanList.add(i, array[i]);
        }
        return booleanList;

    }



}
