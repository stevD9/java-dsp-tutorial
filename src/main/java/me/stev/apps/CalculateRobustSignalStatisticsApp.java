package me.stev.apps;

import me.stev.algorithms.robust.RobustSignalStatistics;
import me.stev.signals.Signal;

public class CalculateRobustSignalStatisticsApp {

    public static void main(String[] args) {

        RobustSignalStatistics sigStats = new RobustSignalStatistics(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double mean = sigStats.calcSigMean();
        System.out.println("The mean is : " + mean);
    }
}
