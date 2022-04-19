package utils;


import constants.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract  class Reader {
    public static List<Boolean> readFileInBooleanArray(String filepath) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        List<Boolean> result = new ArrayList<>();
        int i = 0;
        int symbol = bufferedReader.read();
        while (symbol != -1 && i != Constants.VALUE_BILLION) {  // Когда дойдём до конца файла, получим '-1'
            if((char)symbol == '0') {
                result.add(i, false);
                i++;
            }

            if((char)symbol == '1') {
                result.add(i, true);
                i++;
            }


            symbol = bufferedReader.read(); // Читаем символ
        }

        return result;
    }


}
