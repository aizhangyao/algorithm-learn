package com.aiz.leetcode.exam.v20210926;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Yao
 * @Date Create in 11:10 上午 2021/9/26
 * @Version 1.0
 */
public class Solution {

    public static int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = -nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[nums.length - 1][0] > 0 ? dp[nums.length - 1][0] : -1;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 3, 2};
        System.out.println(maximumDifference(nums));

    }
}
