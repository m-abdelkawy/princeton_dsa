package com.princeton.week3.part1;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // base case
        if (lo >= hi)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, 0, mid);
        sort(a, aux, mid + 1, hi);

        // improvement - the array is already sorted
        if(less(a[mid], a[mid+1]))
            return;

        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
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
