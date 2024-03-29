package com.aiz.leetcode.practice;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 元素和最小的山形三元组I
 * @description https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/
 * @date Create in 14:55 2024/3/29
 */
public class 元素和最小的山形三元组I {
    public int minimumSum(int[] nums) {
        int[] leftMin = new int[nums.length];
        int[] rightMin = new int[nums.length];

        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(nums[i - 1], leftMin[i - 1]);
        }

        rightMin[nums.length - 1] = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i + 1], rightMin[i + 1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > leftMin[i] && nums[i] > rightMin[i]) {
                int sum = leftMin[i] + rightMin[i] + nums[i];
                if (min > sum) {
                    min = sum;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    @Test
    public void test() {
        元素和最小的山形三元组I o = new 元素和最小的山形三元组I();
        // 1,5,3
        int[] nums = {8, 6, 1, 5, 3};
        assert 9 == o.minimumSum(nums);
    }

    @Test
    public void test2() {
        元素和最小的山形三元组I o = new 元素和最小的山形三元组I();
        // 4,7,2
        int[] nums = {5, 4, 8, 7, 10, 2};
        assert 13 == o.minimumSum(nums);
    }

    @Test
    public void test3() {
        元素和最小的山形三元组I o = new 元素和最小的山形三元组I();
        // x
        int[] nums = {6, 5, 4, 3, 4, 5};
        assert -1 == o.minimumSum(nums);
    }
}
