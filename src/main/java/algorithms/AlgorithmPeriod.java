package algorithms;

import constants.Constants;
import model.SequenceListPeriodInfo;
import model.SequencePeriodInfo;
import utils.CheckPeriodByModules;
import utils.PeriodInfoFinder;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgorithmPeriod {

    public static SequencePeriodInfo showPeriodInfo(boolean[] sequence){

        int numberOfEntries = 0;
        for(int i = 0; i < sequence.length; i++){


            boolean [] subSequence = new boolean[i + Constants.VALUE_ONE];

            for( int j = 0; j < subSequence.length; j ++){
                subSequence[j] = sequence[j];
            }
            numberOfEntries = PeriodInfoFinder.getNumberOfEntries(sequence, subSequence);

            if (sequence.length/subSequence.length == numberOfEntries &&
                    CheckPeriodByModules.checkElementsByPeriodModule(sequence, subSequence.length))
                return new SequencePeriodInfo(subSequence.length, subSequence, numberOfEntries);
           }

        return new SequencePeriodInfo();
    }

    public static SequenceListPeriodInfo showListPeriodInfo(List<Boolean> sequence){

        for(int i = 0; i < sequence.size(); i++){

            int numberOfEntries = 0;
            List<Boolean> subSequence = new ArrayList<Boolean>();

            for( int j = 0; j < sequence.size(); j ++){
                subSequence.add(j, sequence.get(j) );
            }
            numberOfEntries = PeriodInfoFinder.getListNumberOfEntries(sequence, subSequence);

            if (sequence.size()/subSequence.size() == numberOfEntries)
                return new SequenceListPeriodInfo(subSequence.size(), subSequence, numberOfEntries);;
        }

        return new SequenceListPeriodInfo();
    }


}




