package com.aiz.lc.offer.day09;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer42
 * @description 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @date Create in 11:29 2023/4/7
 */
public class SolutionOffer42 {

    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为O(n)。
     */
    public int maxSubArray(int[] nums) {
        // dp[i]的含义：以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = new SolutionOffer42().maxSubArray(nums);
        System.out.println(i);
    }


    /**
     * answer1 : 动态规划
     */
}
