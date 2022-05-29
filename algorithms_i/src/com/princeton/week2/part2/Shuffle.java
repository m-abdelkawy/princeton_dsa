package com.princeton.week2.part2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    public void shuffle(Object[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = generateRandomNumber(0,i+1);
            exchange(a, i, r);
        }
    }

    private static int generateRandomNumber(int lo, int hi){
        Random random = new Random();
        return random.nextInt(hi-lo) + lo;
    }

    /**
     * exchanges two array elements with indices i, j
     * @param a array of Comparable
     * @param i index of the 1st element
     * @param j index of the 2nd element
     */
    private static void exchange(Object[] a, int i, int j){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 3, 1};
        System.out.println("Before Shuffling: " + Arrays.toString(nums));
        Shuffle shuffle = new Shuffle();
        shuffle.shuffle(nums);
        System.out.println("After Shuffling:  " + Arrays.toString(nums));
        shuffle.shuffle(nums);
        System.out.println("After Shuffling:  " + Arrays.toString(nums));
        shuffle.shuffle(nums);
        System.out.println("After Shuffling:  " + Arrays.toString(nums));
        shuffle.shuffle(nums);
        System.out.println("After Shuffling:  " + Arrays.toString(nums));
    }
}
