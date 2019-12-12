package me.stev.algorithms.simple;

public class SignalStatistics {

    public static double calcSigMean(double[] sigSrcArr, int sigLength) {
        double mean = 0.0;
        for (int i = 0; i < sigLength; i++) {
            mean += sigSrcArr[i];
        }
        return mean/(double) sigLength;
    }

    public static double calcSigVariance(double[] sigSrcArr, int sigLength) {
        double sigMean = calcSigMean(sigSrcArr, sigLength);
        double variance = 0.0;
        for (int i = 0; i < sigLength; i++) {
            variance += Math.pow((sigSrcArr[i] - sigMean), 2);
        }
        return variance / (double) (sigLength - 1);
    }

    public static double calcSigStd(double[] sigSrcArr, int sigLength) {
        double signalVariance = calcSigVariance(sigSrcArr, sigLength);
        return Math.sqrt(signalVariance);
    }
}
