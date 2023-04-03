package com.aiz.leetcode.practice;

import java.util.HashMap;

/**
 * @ClassName Solution1
 * @Description Two Sum
 * @Author ZhangYao
 * @Date Create in 11:39 2022/9/1
 * @Version 1.0
 */
public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        // (key,value) (元素，位置)
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }

    public static void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }//[0,1]
    }

    public static void test2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }//[0,2]
    }

}
