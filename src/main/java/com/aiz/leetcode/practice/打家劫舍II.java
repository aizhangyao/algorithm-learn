package com.aiz.leetcode.practice;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 打家劫舍II
 * @description https://leetcode.cn/problems/house-robber-ii/description/
 * @date Create in 17:17 2024/4/23
 */
public class 打家劫舍II {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(
                // 偷nums[0]
                nums[0] + robRange(nums, 2, n - 1),
                // 不偷nums[0]
                robRange(nums, 1, n)
        );
    }

    public int robRange(int[] nums, int start, int end) {
        // [start,end)
        int f0 = 0, f1 = 0;
        for (int i = start; i < end; i++) {
            int temp = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }

    @Test
    public void test() {
        打家劫舍II clazz = new 打家劫舍II();
        int[] nums = {2, 3, 2};
        int rob = clazz.rob(nums);
        assert rob == 3;
    }

    @Test
    public void test2() {
        打家劫舍II clazz = new 打家劫舍II();
        int[] nums = {1, 2, 3, 1};
        int rob = clazz.rob(nums);
        assert rob == 4;
    }

    @Test
    public void test3() {
        打家劫舍II clazz = new 打家劫舍II();
        int[] nums = {1, 2, 3};
        int rob = clazz.rob(nums);
        assert rob == 3;
    }
}
