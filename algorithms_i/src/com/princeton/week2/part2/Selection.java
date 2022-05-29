package com.princeton.week2.part2;

import java.util.Arrays;

/**
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 28.05.2022
 * Selection Sort takes O(N^2/2 compares) and N exchanges
 * Selection sort does not depend on the initial order of the input data
 * as it does exchange any way
 * so there is no best case
 */
public class Selection {
    /**
     * sorts an array of Comparable in ascending order in O(N^2) time
     * using a divide and conquer algorithm set i as the minimum
     * then search the rest of the array for the minimum
     * exchange the minimum with the element at i
     * increment i and repeat for the rest of the array from i+1 to the end
     *
     * @param a array of Comparable
     */
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exchange(a, i, min);
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
        Selection selSort = new Selection();
        selSort.sort(nums);
        System.out.println("After Sorting:  " + Arrays.toString(nums));
    }
}
