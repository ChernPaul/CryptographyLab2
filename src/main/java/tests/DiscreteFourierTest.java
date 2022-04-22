package tests;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

import java.util.List;

import static tests.Utils.pow2DoubleArr;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static org.apache.commons.math3.special.Erf.erfc;


public class DiscreteFourierTest {
    public static double run(List<Boolean> bits) {
        if (bits.size() == 0) {
            System.out.println("DiscreteFourierTransformTest:args wrong");
            return -1;
        }
        int n = bits.size();
        double[] r = new double[n];
        double T = sqrt(2.995732274 * n); // ln (1/0.05) = 2,995  T = sqrt(ln(1/0.05)*n)  assumption of randomness
        double N_0 = 0.95 * n / 2; // expected theoretical number of peaks
        int N_1 = 0;    // current observed peak

        for (int i = 0; i < n; i++) {
            if (bits.get(i))
                r[i] = 1.0;
            else
                r[i] = -1.0;
        }
        r = pow2DoubleArr(r);

        FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
        Complex[] result = fft.transform(r, TransformType.FORWARD);

        for (int i = 0; i <= n / 2 - 1; i++) {
            if (result[i].abs() < T) {
                N_1++;  // evaluate current observed peak
            }
        }

        //if (abs(r[0]) < T) N_1++;

        double V = (N_1 - N_0) / sqrt(0.95 * 0.05 * n / 4);     // compute d    // was  under sqrt /2  => /4
        double P = erfc(abs(V) / sqrt(2));                  // compute p value
        System.out.println(" DFT Parameters DATA");
        System.out.println("N_0");
        System.out.println(N_0);
        System.out.println("N_1");
        System.out.println(N_1);
        System.out.println("V");
        System.out.println(V);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" DFT Parameters DATA ended");
        return P;
    }

}