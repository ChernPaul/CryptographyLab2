package utils;

import constants.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class UtilWriter {

    public static void writeBooleanListToFile(String filepath, List<Boolean> listBooleans) throws IOException {

        FileWriter writer = new FileWriter(filepath) ;
        writer.write(ViewHelper.binListViewAsString(listBooleans));
        writer.flush();
    }

    public static void writeBooleanListToFileAsExample(String filepath, List<Boolean> listBooleans) throws IOException {

        FileWriter writer = new FileWriter(filepath) ;
        char current_symbol;


        writer.write('\t');
        for(int i =0; i < 24; i++){

            if(listBooleans.get(i)){
                current_symbol = '1';
            }
            else {
                current_symbol = '0';
            }
            writer.write(current_symbol);
        }


        for(int i = 25; i< listBooleans.size(); i++){
            if(i%25 == 0) {
                writer.write('\n');
                writer.write('\t');
            }

            if(listBooleans.get(i- Constants.VALUE_ONE)){
                current_symbol = '1';
            }
            else {
                current_symbol = '0';
            }
            writer.write(current_symbol);

        }
        writer.flush();
    }


}
