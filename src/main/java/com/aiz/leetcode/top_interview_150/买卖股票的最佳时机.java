package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 买卖股票的最佳时机
 * @description https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @date Create in 15:17 2023/8/7
 */
public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 第i天卖出股票的最佳收益
        int[] dp = new int[prices.length];
        // 初始边界
        dp[0] = 0;
        // 成本
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            // 选择成本小的买入
            cost = Math.min(cost, prices[i]);
        }
        return dp[prices.length - 1];
    }

    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        买卖股票的最佳时机 clazz = new 买卖股票的最佳时机();
        int i = clazz.maxProfit(prices);
        assert i == 5;
    }


    @Test
    public void test2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        买卖股票的最佳时机 clazz = new 买卖股票的最佳时机();
        int i = clazz.maxProfit(prices);
        assert i == 0;
    }
}
