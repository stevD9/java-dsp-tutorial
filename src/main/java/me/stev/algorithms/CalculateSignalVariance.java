package me.stev.algorithms;

public class CalculateSignalVariance {

    public static double execute(double[] sigSrcArr, double sigMean, int sigLength) {
        double variance = 0.0;
        for (int i = 0; i < sigLength; i++) {
            variance += Math.pow((sigSrcArr[i] - sigMean), 2);
        }
        return variance / (double) (sigLength - 1);
    }
}
