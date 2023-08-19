package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 打家劫舍
 * @description https://leetcode.cn/problems/house-robber/
 * @date Create in 21:49 2023/8/19
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        dp[2] = Math.max(dp[0] + nums[2], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    @Test
    public void test() {
        打家劫舍 clazz = new 打家劫舍();
        int[] nums = {1, 2, 3, 1};
        int rob = clazz.rob(nums);
        assert rob == 4;
    }

    @Test
    public void test2() {
        打家劫舍 clazz = new 打家劫舍();
        int[] nums = {2, 7, 9, 3, 1};
        int rob = clazz.rob(nums);
        assert rob == 12;
    }

}
