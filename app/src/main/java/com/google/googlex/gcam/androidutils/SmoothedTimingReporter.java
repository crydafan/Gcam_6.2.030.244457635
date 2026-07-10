package com.google.googlex.gcam.androidutils;

public class SmoothedTimingReporter {
    public final long[] bufferedTimesNanos;
    public long nSamples;

    public SmoothedTimingReporter(int i) {
        this.bufferedTimesNanos = new long[i];
        reset();
    }

    public synchronized void addSample(long j) {
        long j2 = this.nSamples;
        long[] jArr = this.bufferedTimesNanos;
        jArr[(int) (j2 % jArr.length)] = j;
        this.nSamples = j2 + 1;
    }

    public synchronized float averagePeriodNanos() {
        int i;
        int i2;
        long j = this.nSamples;
        if (j >= 2) {
            long[] jArr = this.bufferedTimesNanos;
            int length = jArr.length;
            long j2 = length;
            if (j > j2) {
                i = (int) (j % j2);
                i2 = ((i - 1) + length) % length;
            } else {
                length = (int) (j - 1);
                i = 0;
                i2 = length;
            }
            return ((float) (jArr[i2] - jArr[i])) / (length - 1);
        }
        return 0.0f;
    }

    public synchronized void reset() {
        this.nSamples = 0L;
    }
}
