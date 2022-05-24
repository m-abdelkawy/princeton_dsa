package com.princeton.week1.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

// import java.util.Arrays;
// import java.util.stream.Stream;

public class PercolationStats {
    private final double[] thresholdArr;

    public PercolationStats(int n, int trials) {
        thresholdArr = new double[trials];
        Percolation percolation;

        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            int randomRow;
            int randomCol;
            while (!percolation.percolates()) {
                randomRow = StdRandom.uniform(1, n + 1);
                randomCol = StdRandom.uniform(1, n + 1);

                percolation.open(randomRow, randomCol);
            }
            thresholdArr[i] = (double) percolation.numberOfOpenSites() / (double) (n * n);
        }
    }

    public double mean() {
//        double sum = Arrays.stream(thresholdArr).sum();
//        return sum / thresholdArr.length;

        return StdStats.mean(thresholdArr);
    }

    public double stddev() {
//        double mean = mean();
//        double s2 = Arrays.stream(thresholdArr).map(x -> Math.pow(x - mean, 2)).sum() / (thresholdArr.length - 1);
//
//        return Math.sqrt(s2);

        return StdStats.stddev(thresholdArr);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(thresholdArr.length));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(thresholdArr.length));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(n, trials);

        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}
