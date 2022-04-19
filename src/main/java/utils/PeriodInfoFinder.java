package utils;

import java.util.List;

public abstract class PeriodInfoFinder {
    public static int getNumberOfEntries(boolean[] sequence, boolean [] subSequence){


        int subSequenceIndex = 0;
        int countEntries = 0;

        for(int i=0; i < sequence.length; i++){

            if(sequence[i] != subSequence[subSequenceIndex])
                break;

            subSequenceIndex++;
            if (subSequenceIndex == subSequence.length){
                subSequenceIndex = 0;
                countEntries++;
            }


        }

        return countEntries;


    }

    public static int getListNumberOfEntries(List<Boolean> sequence, List<Boolean> subSequence){


        int subSequenceIndex = 0;
        int countEntries = 0;

        for(int i=0; i < sequence.size(); i++){

            if(sequence.get(i) != subSequence.get(subSequenceIndex))
                break;

            subSequenceIndex++;
            if (subSequenceIndex == subSequence.size()){
                subSequenceIndex = 0;
                countEntries++;
            }


        }

        return countEntries;


    }


}
