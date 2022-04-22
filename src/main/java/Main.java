import algorithms.AlgorithmPeriod;
import algorithms.AlgorithmTask;
import model.LFSRGenerator;
import model.SequencePeriodInfo;
import tests.ApproximateEntropyTest;
import tests.DiscreteFourierTest;
import tests.RandomExcursionTest;
import utils.*;

import java.io.IOException;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {

      //  boolean[] coefficientArrayGen1 = {true, false, false, true, false}; //  1 0 0 1 0 x4 + x
      //   boolean[]  stateArrayGen1 = {true, false, true, false, false};

      //  boolean[] coefficientArrayGen2 = {true, true, true, true, true}; // 1 1 1 1 1 x4 + x3 + x2 + x + 1
      //  boolean[]  stateArrayGen2 = {false, false, true, false, false};

      //  boolean[] coefficientArrayGen3 = {true, false, false, true, true}; // 1 0 0 1 1   x4 + x + 1
      //  boolean[]  stateArrayGen3 = {false, false, true, true, true};

        boolean[] coefficientArrayGen1 = {true, false, false, true, true}; // 1 0 0 1 1   x4 + x + 1
        boolean[]  stateArrayGen1 = {false, false, true, true, true};

        boolean[] coefficientArrayGen2 = {true, false, true, false, false, true}; // 1 0 1 0 0 1 x5 + x3 + 1
        boolean[]  stateArrayGen2 = {false, false, true, false, false, false};

        boolean[] coefficientArrayGen3 = {true, true, true, true, false, true}; //  1 1 1 1 0 1 x5 +x4 + x3 +x2 +1
        boolean[]  stateArrayGen3 = {true, false, true, false, false, true};



        LFSRGenerator generator1 = new LFSRGenerator(stateArrayGen1, coefficientArrayGen1);
        LFSRGenerator generator2 = new LFSRGenerator(stateArrayGen2, coefficientArrayGen2);
        LFSRGenerator generator3 = new LFSRGenerator(stateArrayGen3, coefficientArrayGen3);


        System.out.println("New sequences");
        boolean[] genSequence1 = generator1.generateSequence(1000000);
        boolean[] genSequence2 = generator2.generateSequence(1000000);
        boolean[] genSequence3 = generator3.generateSequence(1000000);
        boolean [] resultBoolArray = AlgorithmTask.majorityNonLinear(genSequence1, genSequence2, genSequence3);

        SequencePeriodInfo seqInfo = AlgorithmPeriod.showPeriodInfo(resultBoolArray);
        System.out.println("Result of show period info");
        //System.out.println(seqInfo.toString());



        String filepath = "D:\\Рабочий стол\\КМЗИ\\2\\ЛР2\\data.e";
        List<Boolean> exp = Reader.readFileInBooleanArray(filepath);
        filepath = "D:\\Рабочий стол\\КМЗИ\\2\\ЛР2\\data.pi";
        List<Boolean> pi = Reader.readFileInBooleanArray(filepath);


        boolean[] sequenceBool = StringToBooleanArray.stringToBoolArray("0110110101");


        System.out.println("Pi");
        System.out.println(RandomExcursionTest.run(pi)[8]);
        System.out.println("Exp");
        System.out.println(RandomExcursionTest.run(exp)[8]);

        System.out.println("Approximate test");
        System.out.println("Pi");
        System.out.println(ApproximateEntropyTest.run(pi));
        System.out.println("Exp");
        System.out.println(ApproximateEntropyTest.run(exp));


        System.out.println("Final test");
        System.out.println("Random Excursion test");
        ViewHelper.printDoubleArray(RandomExcursionTest.run(TransformTypes.arrayToBooleanList(resultBoolArray)));

        System.out.println("Approx test");
        System.out.println(ApproximateEntropyTest.run(TransformTypes.arrayToBooleanList(resultBoolArray)));

        System.out.println("Discrete Fourier test test");
        System.out.println(DiscreteFourierTest.run(TransformTypes.arrayToBooleanList(resultBoolArray)));







    }







}