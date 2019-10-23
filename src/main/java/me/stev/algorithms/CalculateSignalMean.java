package me.stev.algorithms;

public class CalculateSignalMean {

    public static double execute(double[] sigSrcArr, int sigLength) {
        double mean = 0.0;
        for (int i = 0; i < sigLength; i++) {
            mean += sigSrcArr[i];
        }
        return mean/(double) sigLength;
    }
}
