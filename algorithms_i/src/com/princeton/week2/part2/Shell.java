package com.princeton.week2.part2;

import java.util.Arrays;

/**
 * Shell Sort: h-sorts an array in ascending order
 * with h-increments of 3x+1 according to D. Knuth
 * Running time is O(N^1.5)
 *
 * The best sequence of increments is still an open problem
 *
 * number of compares using the 3x+1 increment sort
 * is n*log3(n)
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 28.05.2022
 */
public class Shell {

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3){
            h = 3 * h + 1;
        }
        while(h>=1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >=h && less(a[j], a[j-h]) ; j-=h) {
                    exchange(a, j, j-h);
                }
            }
            h/=3;
        }
    }

    /**
     * exchanges two array elements with indices i, j
     * @param a array of Comparable
     * @param i index of the 1st element
     * @param j index of the 2nd element
     */
    private static void exchange(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
        Integer[] nums = {5,2,3,1};
        System.out.println("Before Sorting: " + Arrays.toString(nums));
        Shell shellSort = new Shell();
        shellSort.sort(nums);
        System.out.println("After Sorting:  " + Arrays.toString(nums));
    }
}
