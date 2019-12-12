package me.stev.algorithms.robust;

public class RobustSignalStatistics {

    public static double calcSigMean(double[] sigSrcArr, int blockSize) {

        double mean = 0.0;
        double sum = 0.0;
        int blkCnt; // Loop counter
        int idx = 0;

        double in1,in2,in3,in4;

        blkCnt = blockSize >> 2; // blockSize / 2^2 = blockSize / 4

        // Compute 4 outputs at a time
        while (blkCnt > 0) {

            in1 = sigSrcArr[idx++];
            in2 = sigSrcArr[idx++];
            in3 = sigSrcArr[idx++];
            in4 = sigSrcArr[idx++];

            sum += in1;
            sum += in2;
            sum += in3;
            sum += in4;

            blkCnt--;
        }

        blkCnt = blockSize % 0x4;

        while (blkCnt > 0) {

            sum += sigSrcArr[idx++];
            blkCnt--;
        }

        mean = sum / (double) blockSize;
        return mean;
    }

    public double calcSigVariance(double[] sigSrcArr, int blockSize) {

    }
}
