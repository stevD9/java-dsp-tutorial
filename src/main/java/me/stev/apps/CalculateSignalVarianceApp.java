package me.stev.apps;

import me.stev.algorithms.CalculateSignalMean;
import me.stev.algorithms.CalculateSignalVariance;
import me.stev.signals.Signal;

public class CalculateSignalVarianceApp {

    public static void main(String[] args) {
        double mean = CalculateSignalMean.execute(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double variance = CalculateSignalVariance.execute(Signal.InputSignal_f32_1kHz_15kHz, mean, Signal.InputSignal_f32_1kHz_15kHz.length);
        System.out.println("Mean : \n" + mean);
        System.out.println("Variance : \n" + variance);
    }
}
