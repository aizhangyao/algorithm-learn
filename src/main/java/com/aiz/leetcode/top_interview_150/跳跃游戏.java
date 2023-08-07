package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 跳跃游戏
 * @description https://leetcode.cn/problems/jump-game/
 * @date Create in 15:51 2023/8/7
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        // 在第i块石头最远还可以跳多远
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 1) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
        }
        return dp[nums.length - 1] >= 0;
    }

    @Test
    public void test() {
        跳跃游戏 clazz = new 跳跃游戏();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean b = clazz.canJump(nums);
        assert b == true;
    }

    @Test
    public void test2() {
        跳跃游戏 clazz = new 跳跃游戏();
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean b = clazz.canJump(nums);
        assert b == false;
    }
}
