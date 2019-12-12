package me.stev.algorithms.simple;

public class SignalStatistics {

    private double[] sigSrcArr;
    private int sigLength;

    public SignalStatistics() {

    }

    public SignalStatistics(double[] sigSrcArr, int sigLength) {
        this.sigSrcArr = sigSrcArr;
        this.sigLength = sigLength;
    }

    public double[] getSigSrcArr() {
        return sigSrcArr;
    }

    public void setSigSrcArr(double[] sigSrcArr) {
        this.sigSrcArr = sigSrcArr;
    }

    public int getSigLength() {
        return sigLength;
    }

    public void setSigLength(int sigLength) {
        this.sigLength = sigLength;
    }

    public double calcSigMean() {
        double mean = 0.0;
        for (int i = 0; i < sigLength; i++) {
            mean += sigSrcArr[i];
        }
        return mean/(double) sigLength;
    }

    public double calcSigVariance() {
        double sigMean = calcSigMean();
        double variance = 0.0;
        for (int i = 0; i < sigLength; i++) {
            variance += Math.pow((sigSrcArr[i] - sigMean), 2);
        }
        return variance / (double) (sigLength - 1);
    }

    public double calcSigStd() {
        double signalVariance = calcSigVariance();
        return Math.sqrt(signalVariance);
    }
}
