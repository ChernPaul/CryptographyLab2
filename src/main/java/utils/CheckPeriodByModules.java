package utils;

public abstract class CheckPeriodByModules {
    public static boolean checkElementsByPeriodModule(boolean[] sequence, int periodValue){
        for(int i = 0; i < sequence.length; i++){
            if (sequence[i] != sequence[i%periodValue])
                return false;
        }


        return true;
    }

}
