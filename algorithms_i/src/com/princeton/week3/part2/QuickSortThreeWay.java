package com.princeton.week3.part2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class QuickSortThreeWay {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        // base case
        if(lo >= hi){
            return;
        }

        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;

        while (i<=gt) {
            int cmp = a[i].compareTo(v);
            if(cmp <0)
                exchange(a, i++, lt++);
            else if(cmp > 0)
                exchange(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {5,3,4,1,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
