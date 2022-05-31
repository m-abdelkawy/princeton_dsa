package com.princeton.week3.part1;


import java.util.Arrays;
import java.util.Comparator;

public class InsertionComparator {
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(comparator,a[j], a[j-1]); j--) {
                exchange(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparator comparator, Object u, Object v) {
        return comparator.compare(u, v) < 0;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Comparator intComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer o1Int = (Integer)o1;
                Integer o2Int = (Integer)o2;
                if(o1Int.compareTo(o2Int) < 0) return -1;
                else if (o1Int.compareTo(o2Int) == 0) return 0;
                else return 1;
            }
        };

        Comparator intComparator2 = (o1, o2)->{
            Integer o1Int = (Integer)o1;
            Integer o2Int = (Integer)o2;
            return o1Int - o2Int;
        };

        Integer[] nums = {5, 2, 3, 1};
        System.out.println("Before Sorting: " + Arrays.toString(nums));
        InsertionComparator.sort(nums, intComparator);
        System.out.println("After Sorting:  " + Arrays.toString(nums));
    }
}
