package algorithms;

import model.LFSRGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgorithmTask {
    public static boolean [] majorityNonLinear(boolean [] sequence1,
                                               boolean [] sequence2,
                                               boolean [] sequence3
                                              )
    {
        int sequenceLength = sequence1.length;
        boolean[] result = new boolean[sequenceLength];
        int currentSequenceIndex1 = 0;
        int currentSequenceIndex2 = 0;
        int currentSequenceIndex3 = 0;


        for (int i = 0; i < sequenceLength; i++){

            if(!sequence1[currentSequenceIndex1] && !sequence2[currentSequenceIndex2]){
                if(!sequence3[i]){
                    currentSequenceIndex1++;
                    currentSequenceIndex2++;
                    currentSequenceIndex3++;
                    result[i] = false;
                    continue;
                }
                else {
                    currentSequenceIndex1++;
                    currentSequenceIndex2++;
                    result[i] = false;
                    continue;
                }

            }

            if(sequence1[currentSequenceIndex1] && sequence2[currentSequenceIndex2]){
                if(sequence3[i]){
                    currentSequenceIndex1++;
                    currentSequenceIndex2++;
                    currentSequenceIndex3++;
                    result[i] = true;
                    continue;
                }
                else {
                    currentSequenceIndex1++;
                    currentSequenceIndex2++;
                    result[i] = true;
                    continue;
                }

            }

            if(!sequence1[currentSequenceIndex1] && sequence2[currentSequenceIndex2]){
                if(sequence3[i]){
                    currentSequenceIndex2++;
                    result[i] = true;
                }
                else {
                    currentSequenceIndex1++;
                    result[i] = false;
                }
                currentSequenceIndex3++;
                continue;

            }

            if(sequence1[currentSequenceIndex1] && !sequence2[currentSequenceIndex2]){
                if(sequence3[i]){
                    currentSequenceIndex1++;
                    result[i] = true;
                }
                else {
                    currentSequenceIndex2++;
                    result[i] = false;
                }
                currentSequenceIndex3++;

            }

        }

        return result;
    }







}
