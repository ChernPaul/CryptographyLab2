import algorithms.AlgorithmPeriod;
import algorithms.AlgorithmTask;
import model.LFSRGenerator;
import model.SequencePeriodInfo;
import tests.ApproximateEntropyTest;
import tests.DiscreteFourierTest;
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


        boolean[] genSequence1 = generator1.generateSequence(20);
        boolean[] genSequence2 = generator2.generateSequence(20);
        boolean[] genSequence3 = generator3.generateSequence(20);

        System.out.println("View sequences");
        System.out.println(ViewHelper.binViewAsString(genSequence1));
        System.out.println(ViewHelper.binViewAsString(genSequence2));
        System.out.println(ViewHelper.binViewAsString(genSequence3));

        boolean [] resultBoolArray = AlgorithmTask.majorityNonLinear(genSequence1, genSequence2, genSequence3);
        System.out.println("Result of Group generators");
        System.out.println(ViewHelper.binViewAsString(resultBoolArray));


        System.out.println("New sequences");
        genSequence1 = generator1.generateSequence(10000);
        genSequence2 = generator2.generateSequence(10000);
        genSequence3 = generator3.generateSequence(10000);
        boolean [] resultBoolArray1 = AlgorithmTask.majorityNonLinear(genSequence1, genSequence2, genSequence3);
        // System.out.println("Long Sequences combo");
        // System.out.println(ViewHelper.binViewAsString(resultBoolArray1));
        SequencePeriodInfo seqInfo = AlgorithmPeriod.showPeriodInfo(resultBoolArray1);
        System.out.println("Result of show period info");
        System.out.println(seqInfo.toString());



        String filepath = "D:\\Рабочий стол\\КМЗИ\\2\\ЛР2\\data.e";
        List<Boolean> exp = Reader.readFileInBooleanArray(filepath);
        filepath = "D:\\Рабочий стол\\КМЗИ\\2\\ЛР2\\data.pi";
        List<Boolean> pi = Reader.readFileInBooleanArray(filepath);



        double FFTTestResult = DiscreteFourierTest.run(utils.TransformTypes.arrayToBooleanList(resultBoolArray));
        System.out.println("Spectral Test");
        System.out.println(FFTTestResult);

        System.out.println("FFT result");
        FFTTestResult = DiscreteFourierTest.run(pi);
        System.out.println(FFTTestResult);

        System.out.println("FFT result");
        FFTTestResult = DiscreteFourierTest.run(exp);
        System.out.println(FFTTestResult);


        double EntropyTestResult = ApproximateEntropyTest.run(pi);
        System.out.println("Approximate result");
        System.out.println(EntropyTestResult);

        EntropyTestResult = ApproximateEntropyTest.run(exp);
        System.out.println("Approximate result");
        System.out.println(EntropyTestResult);



        UtilWriter.writeBooleanListToFile("D:\\Рабочий стол\\pi.txt",pi);
        System.out.println(pi.size());
        System.out.println(exp.size());

        UtilWriter.writeBooleanListToFileAsExample("D:\\Рабочий стол\\pi1.txt",pi);
        UtilWriter.writeBooleanListToFileAsExample("D:\\Рабочий стол\\exp1.txt",exp);

        String testData = "1100100100001111110110101010001000100001011010001100001000110100110001001100011001100010100010111000";

        boolean[] testDataArray = StringToBooleanArray.stringToBoolArray(testData);
        System.out.println("FFT");
        FFTTestResult = DiscreteFourierTest.run(TransformTypes.arrayToBooleanList(testDataArray));
        System.out.println("FFT result test data");
        System.out.println(FFTTestResult);
        System.out.println("Test  pi");
        FFTTestResult = DiscreteFourierTest.run(pi);
        System.out.println("FFT result pi");
        System.out.println(FFTTestResult);

        testData = "1001010011";
        testDataArray = StringToBooleanArray.stringToBoolArray(testData);
        System.out.println("FFT");
        FFTTestResult = DiscreteFourierTest.run(TransformTypes.arrayToBooleanList(testDataArray));
        System.out.println("FFT result test data");
        System.out.println(FFTTestResult);
    }







}