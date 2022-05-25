package com.princeton.week1.part1;

public class QuickFindUF {
    private int[] id;

    /**
     * Initialize in time O(N)
     * @param N size of the array
     */
    public QuickFindUF(int N) {
        //N array accesses
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Find if p and q are connected in time O(1)
     * @param p first node
     * @param q second node
     * @return true if p and q are connected, otherwise false
     */
    private boolean connected(int p, int q) {
        // 2 array accesses
        return id[p] == id[q];
    }

    /**
     * Connects two nodes in time O(N)
     * @param p first node
     * @param q second node
     */
    private void union(int p, int q) {
        // set the value of id[p] in the id array equal to the value of id[q]
        // 2N + 2 array accesses
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
