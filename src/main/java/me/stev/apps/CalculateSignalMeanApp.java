package me.stev.apps;

import me.stev.algorithms.CalculateSignalMean;
import me.stev.signals.Signal;

public class CalculateSignalMeanApp {

    public static void main(String[] args) {

        double mean = CalculateSignalMean.execute(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        System.out.println("Mean : \n" + mean);
    }
}
