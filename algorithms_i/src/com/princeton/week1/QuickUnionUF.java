package com.princeton.week1;

public class QuickUnionUF {
    private int[] id;

    /**
     * Initializes in time O(N)
     * @param N size of input data
     */
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * calculates the root of node i in time O(N)
     * @param i node index
     * @return the root of node i
     */
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * checks if p and q are connected in time O(N)
     * @param p first node
     * @param q second node
     * @return true if p and q are connected, otherwise false
     */
    private boolean connected(int p, int q){
        return root(p) == root(q);
    }

    /**
     * connects two nodes p and q in time O(N) including cost of finding root
     * @param p first node
     * @param q second node
     */
    private void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i]=j;
    }
}
