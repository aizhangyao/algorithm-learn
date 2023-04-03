package com.aiz.leetcode.practice;

import java.util.Arrays;

/**
 * @ClassName Solution217
 * @Description 存在重复元素
 * @Author ZhangYao
 * @Date Create in 14:20 2022/8/29
 * @Version 1.0
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution217 solution217 = new Solution217();
        int[] nums_1 = new int[]{1, 2, 3, 1};
        int[] nums_2 = new int[]{1, 2, 3, 4};
        int[] nums_3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(solution217.containsDuplicate(nums_1));//true
        System.out.println(solution217.containsDuplicate(nums_2));//false
        System.out.println(solution217.containsDuplicate(nums_3));//true
    }
}
