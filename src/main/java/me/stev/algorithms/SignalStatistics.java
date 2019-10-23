package me.stev.algorithms;

public class SignalStatistics {

    public static double calcSigMean(double[] sigSrcArr, int sigLength) {
        double mean = 0.0;
        for (int i = 0; i < sigLength; i++) {
            mean += sigSrcArr[i];
        }
        return mean/(double) sigLength;
    }

    public static double calcSigVariance(double[] sigSrcArr, double sigMean, int sigLength) {
        double variance = 0.0;
        for (int i = 0; i < sigLength; i++) {
            variance += Math.pow((sigSrcArr[i] - sigMean), 2);
        }
        return variance / (double) (sigLength - 1);
    }

    public static double calcSigStd(double signalVariance) {
        return Math.sqrt(signalVariance);
    }
}
