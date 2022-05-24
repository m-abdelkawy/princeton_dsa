 package com.princeton.week1.assignment;

// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdRandom;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Link: https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 */
public class Percolation {
    private final WeightedQuickUnionUF uf;
    private boolean[][] sites;
    private final int len;
    private int nOpenSites;
    private final int top;
    private final int bottom;

    /**
     * Creates n * n array of sites that are blocked by default
     *
     * @param n size of the array
     */
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        len = n;
        sites = new boolean[n][n];
        top = 0;
        bottom = n * n + 1;
        uf = new WeightedQuickUnionUF(n * n + 2);
    }

    public void open(int row, int col) {
        if (row < 1 || row > len || col < 1 || col > len)
            throw new IllegalArgumentException();

        if (isOpen(row, col))
            return;

        sites[row - 1][col - 1] = true;
        nOpenSites++;

        // if 1st row, connect with virtual top
        if (row == 1) {
            uf.union(encode(row, col), top);
        }
        // if last row, connect with virtual bottom
        if (row == len) {
            uf.union(encode(row, col), bottom);
        }

        // connect with open neighbour sites
        // 1. top
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(encode(row, col), encode(row - 1, col));
        }
        // 2. bottom
        if (row < len && isOpen(row + 1, col)) {
            uf.union(encode(row, col), encode(row + 1, col));
        }
        // 3. left
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(encode(row, col), encode(row, col - 1));
        }
        // 4. right
        if (col < len && isOpen(row, col + 1)) {
            uf.union(encode(row, col), encode(row, col + 1));
        }
    }

    /**
     * checks if the site is open, i.e if the value in the sites array is true
     *
     * @param row row 1-based index
     * @param col col 1-based index
     * @return true if the site is open, otherwise false
     */
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > len || col < 1 || col > len)
            throw new IllegalArgumentException();
        return sites[row - 1][col - 1] == true;
    }

    /**
     * checks if site at (row, col) is connected to the virtual top site
     *
     * @param row row 1-based index
     * @param col col 1-based index
     * @return true if the site is full, false otherwise
     */
    public boolean isFull(int row, int col) {
        if (row < 1 || row > len || col < 1 || col > len)
            throw new IllegalArgumentException();

        // return uf.connected(encode(row, col), top);
        return uf.find(encode(row, col)) == uf.find(top);
    }

    /**
     * @return number of open sites
     */
    public int numberOfOpenSites() {
        return nOpenSites;
    }

    /**
     * checks if the system percolates, i.e, top and bottom are connected
     *
     * @return true if top and bottom are connected, false otherwise
     */
    public boolean percolates() {
        // return uf.connected(top, bottom);
        return uf.find(top) == uf.find(bottom);
    }

    /**
     * encodes the (row, col) index of a 2D array into 1D
     *
     * @param row row index of the site (row, col)
     * @param col col index of the site (row, col)
     * @return 1D number that represents the rank of the site in a 1-D array
     */
    private int encode(int row, int col) {
        return len * (row - 1) + col;
    }

    /**
     * The test client (optional)
     *
     * @param args
     */
    public static void main(String[] args) {
//        int size = StdIn.readInt();
//
//        Percolation percolation = new Percolation(size);
//        int randomRow;
//        int randomCol;
//        while(!percolation.percolates()){
//            randomRow = StdRandom.uniform(1, size+1);
//            randomCol = StdRandom.uniform(1, size+1);
//
//            percolation.open(randomRow, randomCol);
//        }
//
//        System.out.println("Percolation Threshold: " + (double)percolation.numberOfOpenSites()/(double) (size*size));
    }
}
