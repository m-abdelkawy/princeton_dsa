package com.princeton.week1.part2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author M. Abdelkawy
 * @version 1.0.0, 25.05.2022
 */
public class ThreeSum {
    /**
     * calculates the count of distinct triplets that has summation equal to target in time O(N^2 log N)
     * @param nums array of integers
     * @param target the target integer
     * @return the count of distinct triplets that has summation equal to target
     */
    public int threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> sortedList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int index = Collections
                        .binarySearch(sortedList, target - (nums[i] + nums[j]));
                if (index >= 0 && index < nums.length && nums[j] < nums[index] && nums[index] + nums[i] + nums[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 30, 40, -10, 0, -20, 10, -40};

        ThreeSum threeSum = new ThreeSum();

        System.out.println(threeSum.threeSum(nums, 0));
    }
}
