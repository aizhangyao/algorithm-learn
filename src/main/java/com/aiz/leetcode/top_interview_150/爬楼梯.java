package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 爬楼梯
 * @description https://leetcode.cn/problems/climbing-stairs/
 * @date Create in 21:40 2023/8/19
 */
public class 爬楼梯 {
    /**
     * 动态规划
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 递归 会超时
     */
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    @Test
    public void test() {
        爬楼梯 clazz = new 爬楼梯();
        int i = clazz.climbStairs(2);
        assert i == 2;
    }

    @Test
    public void test2() {
        爬楼梯 clazz = new 爬楼梯();
        int i = clazz.climbStairs(3);
        assert i == 3;
    }
}
