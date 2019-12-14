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

    public static double calcSigVariance(double[] sigSrcArr, int blockSize) {

        double variance;
        double sum = 0.0;
        int blkCnt;
        int idx = 0;

        double fMean, fValue;
        double fSum = 0.0;
        double in1,in2,in3,in4;

        if (blockSize <= 1) {
            variance = 0.0;
            return variance;
        }

        blkCnt = blockSize >> 2;

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

        fMean = sum / (double) blockSize;

        idx = 0;
        blkCnt = blockSize >> 2;

        while (blkCnt > 0) {

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            blkCnt--;
        }

        blkCnt = blockSize % 0x4;

        while (blkCnt > 0) {

            fValue = sigSrcArr[idx++] - fMean;
            fSum =+ fValue * fValue;

            blkCnt--;
        }

        variance = fSum / (double) (blockSize - 1);

        return variance;
    }

    public static double calcSigStd(double[] sigSrcArr, int blockSize) {

        double std;
        double sum = 0.0;
        int blkCnt;
        int idx = 0;

        double sumOfSquares = 0.0;
        double in;
        double squareOfSum;
        double var;

        if (blockSize <= 1) {
            std = 0.0;
            return std;
        }


        blkCnt = blockSize >> 2;

        while (blkCnt > 0) {

            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;

            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;

            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;

            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;

            blkCnt--;
        }

        blkCnt = blockSize % 0x4;

        while (blkCnt > 0) {

            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;

            blkCnt--;
        }

        squareOfSum = (sum * sum) / (double) (blockSize);
        var = (sumOfSquares - squareOfSum) / (blockSize - 1.0);
        std = Math.sqrt(var);

        return std;
    }

    public static double calcSigRms(double[] sigSrcArr, int blockSize) {

        double rms;
        double sum = 0.0;
        int blkCnt;
        int idx = 0;
        double in;

        blkCnt = blockSize >> 2;

        while (blkCnt > 0) {

            in = sigSrcArr[idx++];
            sum += in * in;

            in = sigSrcArr[idx++];
            sum += in * in;

            in = sigSrcArr[idx++];
            sum += in * in;

            in = sigSrcArr[idx++];
            sum += in * in;

            blkCnt--;

        }

        blkCnt = blockSize % 0x4;

        while (blkCnt > 0) {

            in = sigSrcArr[idx++];
            sum += in * in;

            blkCnt--;
        }

        rms = Math.sqrt(sum / (double) blockSize);

        return rms;
    }

    public static void calcSigMax(double[] sigSrcArr, int blockSize, double[] destArray) {

        double maxValue1, maxValue2, out;
        double blkCnt, outIndex;
        double count = 0.0;
        int idx = 0;

        outIndex = 0.0;

        out = sigSrcArr[idx++];

        blkCnt = (blockSize - 1) >> 2;

        while (blkCnt > 0) {

            maxValue1 = sigSrcArr[idx++];
            maxValue2 = sigSrcArr[idx++];

            if (out < maxValue1) {
                out = maxValue1;
                outIndex = count + 1;
            }

            if (out < maxValue2) {
                out = maxValue2;
                outIndex = count + 2;
            }

            maxValue1 = sigSrcArr[idx++];
            maxValue2 = sigSrcArr[idx++];

            if (out < maxValue1) {
                out = maxValue1;
                outIndex = count + 3;
            }

            if (out < maxValue2) {
                out = maxValue2;
                outIndex = count + 4;
            }

            count += 4;
            blkCnt--;
        }

        blkCnt = (blockSize - 1) % 0x4;
        while (blkCnt > 0) {

            maxValue1 = sigSrcArr[idx++];

            if (out < maxValue1) {
                out = maxValue1;
                outIndex = blockSize - blkCnt;
            }

            blkCnt--;
        }

        destArray[0] = out;
        destArray[1] = outIndex;
    }

    public static void calcSigMin(double[] sigSrcArr, int blockSize, double[] destArray) {

        double minValue1, minValue2, out;
        int blkCnt, outIndex, count;
        int idx = 0;
        count = 0;
        outIndex = 0;
        out = sigSrcArr[idx++];

        blkCnt = (blockSize - 1) >> 2;

        while (blkCnt > 0) {

            minValue1 = sigSrcArr[idx++];
            minValue2 = sigSrcArr[idx++];

            if (out > minValue1) {
                out = minValue1;
                outIndex = count + 1;
            }

            if (out > minValue2) {
                out = minValue2;
                outIndex = count + 2;
            }

            minValue1 = sigSrcArr[idx++];
            minValue2 = sigSrcArr[idx++];

            if (out > minValue1) {
                out = minValue1;
                outIndex = count + 3;
            }

            if (out > minValue2) {
                out = minValue2;
                outIndex = count + 4;
            }

            count += count + 4;
            blkCnt--;
        }

        blkCnt = (blockSize - 1) % 0x4;
        while (blkCnt > 0) {

            minValue1 = sigSrcArr[idx++];
            if (out > minValue1) {
                out = minValue1;
                outIndex = blockSize - blkCnt;
            }

            blkCnt--;
        }

        destArray[0] = out;
        destArray[1] = outIndex;
    }
}
