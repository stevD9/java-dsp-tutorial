package me.stev.apps;

import me.stev.algorithms.robust.RobustSignalStatistics;
import me.stev.signals.Signal;

public class CalculateRobustSignalStatisticsApp {

    public static void main(String[] args) {

        double mean = RobustSignalStatistics.calcSigMean(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        System.out.println("The mean is : " + mean);
    }
}
