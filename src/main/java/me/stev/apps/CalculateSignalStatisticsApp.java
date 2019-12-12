package me.stev.apps;

import me.stev.algorithms.simple.SignalStatistics;
import me.stev.signals.Signal;

public class CalculateSignalStatisticsApp {

    public static void main(String[] args) {
        double mean = SignalStatistics.calcSigMean(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double variance = SignalStatistics.calcSigVariance(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double std = SignalStatistics.calcSigStd(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        System.out.println("Mean : \n" + mean);
        System.out.println("Variance : \n" + variance);
        System.out.println("Std : \n" + std);
    }
}
