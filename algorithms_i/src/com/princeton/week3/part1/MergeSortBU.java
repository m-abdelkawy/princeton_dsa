package com.princeton.week3.part1;

import java.util.Arrays;

public class MergeSortBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(less(aux[i], aux[j]))
                a[k] = aux[i++];
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++];
        }
    }

    /**
     * compares two Comparable arguments
     * @param u first param
     * @param v second param
     * @return true if v is less than u, false otherwise
     */
    private static boolean less(Comparable u, Comparable v){
        return u.compareTo(v) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {5,2,3,1};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
