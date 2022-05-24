package com.princeton.week1;

/**
 * Find: takes time proportional to depth of p and q
 * Union: takes constant time, given roots
 *
 * Proposition. Depth of any node x is at most Log N.
 * Proof: depth of x increases by 1 when tree T1 containing x is merged into another tree T2
 * the size of the tree T1 at least doubles since |T2| >= |T1|
 * size of tree containing x can double at most Log N times.
 */
public class QuickUnionUFWeighted {
    private int[] id;
    private int[] sz;

    /**
     * Initializes in time O(N)
     * @param N size of input data
     */
    public QuickUnionUFWeighted(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] =1;
        }
    }

    /**
     * find the root of the node in time O(Log N)
     * @param i node index
     * @return the index of the root
     */
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * finds if two nodes, p and q, are connected in time O(Log N)
     * including cost of finding the root
     * @param p first node
     * @param q second node
     * @return true if p and q are connected, otherwise false
     */
    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * connects two nodes p and q in time O(Log N) including the cost of finding the root
     * @param p first node
     * @param q second node
     */
    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(i==j)
            return;
        if(sz[i]<sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
        }else{
            id[j]=i;
            sz[i]+=sz[j];
        }
    }
}