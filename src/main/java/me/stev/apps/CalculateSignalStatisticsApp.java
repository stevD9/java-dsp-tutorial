package me.stev.apps;

import me.stev.algorithms.SignalStatistics;
import me.stev.signals.Signal;

public class CalculateSignalStatisticsApp {

    public static void main(String[] args) {
        SignalStatistics sigStats = new SignalStatistics(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double mean = sigStats.calcSigMean();
        double variance = sigStats.calcSigVariance();
        double std = sigStats.calcSigStd();
        System.out.println("Mean : \n" + mean);
        System.out.println("Variance : \n" + variance);
        System.out.println("Std : \n" + std);
    }
}
