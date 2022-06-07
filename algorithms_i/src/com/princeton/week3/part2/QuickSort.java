package com.princeton.week3.part2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * sort array of Comparable in O(n log n) time on average
 * Quick sort is not stable
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 02.06.2022
 */
public class QuickSort {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        Comparable partitionElm = a[lo];

        while (true) {
            while (less(a[++i], partitionElm)){
                if(i == hi) break;
            }
            while(less(partitionElm, a[--j])){
                if(j == lo) break;
            }

            if(i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {5,5,5,5,5,5};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
