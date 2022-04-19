package utils;

public abstract class StringToBooleanArray {
    public static boolean[] stringToBoolArray(String sequence){

        boolean [] result = new boolean[sequence.length()];


        for(int i=0; i < sequence.length(); i++){
             if(sequence.charAt(i) == '1'){
                 result[i] = true;
             }
             else{
                 result[i] = false;
             }
        }
        return  result;
    }

}
