package com.princeton.week1.part1;

/**
 * improvement 2 after weighted union find
 */
public class QuickUnionUFPathCompression {
    int[] id;
    int[] sz;

    public QuickUnionUFPathCompression(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while (i != id[i]){
            id[i] = id[id[i]]; //flattening more
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
