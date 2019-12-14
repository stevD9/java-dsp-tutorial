package me.stev.apps;

import me.stev.algorithms.robust.RobustSignalStatistics;
import me.stev.signals.Signal;

public class CalculateRobustSignalStatisticsApp {

    public static void main(String[] args) {

        double mean = RobustSignalStatistics.calcSigMean(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double variance = RobustSignalStatistics.calcSigVariance(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double std = RobustSignalStatistics.calcSigStd(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);
        double rms = RobustSignalStatistics.calcSigRms(Signal.InputSignal_f32_1kHz_15kHz, Signal.InputSignal_f32_1kHz_15kHz.length);

        System.out.println("The mean is : " + mean);
        System.out.println("The variance is : " + variance);
        System.out.println("The standard deviation is : " + std);
        System.out.println("The RMS is : " + rms);

        double[] arrayTestSignal = new double[] {1,2,3,567,67867,234,568678,314134,54674657,234562356,467846784,234562456,567467};
        double[] destArrayMax = new double[2];
        double[] destArrayMin = new double[2];
        RobustSignalStatistics.calcSigMax(arrayTestSignal, arrayTestSignal.length, destArrayMax);
        RobustSignalStatistics.calcSigMin(arrayTestSignal, arrayTestSignal.length, destArrayMin);
        System.out.println("The max is : " + destArrayMax[0]);
        System.out.println("The index is : " + destArrayMax[1]);

        System.out.println("The min is : " + destArrayMin[0]);
        System.out.println("The index is : " + destArrayMin[1]);
    }
}
