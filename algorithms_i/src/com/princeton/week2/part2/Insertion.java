package com.princeton.week2.part2;

import java.util.Arrays;

/**
 * sorts an array of Comparable in N^2/4 time
 * N^2/4 compares and N^2/4 exchanges on average
 * it is twice as fast as the selection sort
 *
 * Insertion sort depends on the initial order of inout data
 * Best case: (Array is sorted) no exchange operation, running time is O(N)
 * The algorithm just verifies that every element has one that is less on the left side
 * (N-1) compares and 0 exchanges
 *
 * Worst Case: (Array is sorted in descending order and no duplicates), O(N^2)
 * (N^2/2) compares and (N^2/2) exchanges
 *
 * Partially sorted arrays are arrays for which the number of inversions is linear
 * i.e, no of inversions is <= cN
 * for those arrays, the Insertion sort runs in linear time (O(N))
 * as the number of exchanges is equal to the number of inversions
 * and there is an extra compare for every element except for the first
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 28.05.2022
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        if (N <= 1)
            return;
        int j;
        for (int i = 1; i < N; i++) {
            j = i;
            while (j > 0 && less(a[j], a[j - 1])) {
                exchange(a, j, j - 1);
                j--;
            }
        }
    }

    public static void sort2(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                }else{
                    break;
                }
            }
        }
    }

    public static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 3, 1};
        System.out.println("Before Sorting: " + Arrays.toString(nums));
        Insertion insertion = new Insertion();
        insertion.sort2(nums);
        System.out.println("After Sorting:  " + Arrays.toString(nums));
    }
}
