package tests;

import constants.Constants;

import java.util.List;
import static org.apache.commons.math3.special.Erf.erfc;
public abstract class RandomExcursionTest {

    public static double[] run(List<Boolean> bits){
        int n = bits.size();
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            if (bits.get(i))
                r[i] = 1;
            else
                r[i] = -1;
        }

        int[] cumSum = new int[n+2];
        cumSum[0] = 0;
        cumSum[1] = r[0];
        cumSum[n+1] = 0;
        int sumElementsBefore = 0;
        for(int i = 2; i < n+1; i++){
            cumSum[i] = cumSum[i-1]  + r[i-1];
        }
        int [] countOfSumValue = new int[19];
        for(int i =0; i < 19;i++)
            countOfSumValue[i] = 0;


        for(int i =0; i < n+2;i++) {
            switch (cumSum[i]) {
                case -9:
                    countOfSumValue[0]++;
                    break;
                case -8:
                    countOfSumValue[1]++;
                    break;
                case -7:
                    countOfSumValue[2]++;
                    break;
                case -6:
                    countOfSumValue[3]++;
                    break;
                case -5:
                    countOfSumValue[4]++;
                    break;
                case -4:
                    countOfSumValue[5]++;
                    break;
                case -3:
                    countOfSumValue[6]++;
                    break;
                case -2:
                    countOfSumValue[7]++;
                    break;
                case -1:
                    countOfSumValue[8]++;
                    break;
                case 0:
                    countOfSumValue[9]++;
                    break;
                case 1:
                    countOfSumValue[10]++;
                    break;
                case 2:
                    countOfSumValue[11]++;
                    break;
                case 3:
                    countOfSumValue[12]++;
                    break;
                case 4:
                    countOfSumValue[13]++;
                    break;
                case 5:
                    countOfSumValue[14]++;
                    break;
                case 6:
                    countOfSumValue[15]++;
                    break;
                case 7:
                    countOfSumValue[16]++;
                    break;
                case 8:
                    countOfSumValue[17]++;
                    break;
                case 9:
                    countOfSumValue[18]++;
                    break;
                default:
                    break;
            }
        }
        double[] PValuesArray = new double[18];
        int j =  countOfSumValue[9] - Constants.VALUE_ONE;


        for(int i = 1; i < 10; i++)
            PValuesArray[i -1] = erfc((Math.abs(countOfSumValue[i -1] -j))/Math.sqrt(2*j*(4*Math.abs(i - 10) - 2)));

        for(int i = 1; i < 10; i++)
            PValuesArray[i+8] = erfc((Math.abs(countOfSumValue[i+9] -j))/Math.sqrt(2*j*(4*Math.abs(i) - 2)));
        return  PValuesArray;

    }



}
