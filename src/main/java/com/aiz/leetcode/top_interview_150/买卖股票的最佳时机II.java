package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 买卖股票的最佳时机II
 * @description https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @date Create in 15:38 2023/8/7
 */
public class 买卖股票的最佳时机II {

    // 找极值点
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int dp[] = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            dp[i] = profit > 0 ? dp[i - 1] + profit : dp[i - 1];
        }
        return dp[prices.length - 1];
    }

    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        买卖股票的最佳时机II clazz = new 买卖股票的最佳时机II();
        int i = clazz.maxProfit(prices);
        assert i == 7;
    }

    @Test
    public void test2() {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        买卖股票的最佳时机II clazz = new 买卖股票的最佳时机II();
        int i = clazz.maxProfit(prices);
        assert i == 4;
    }

    @Test
    public void test3() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        买卖股票的最佳时机II clazz = new 买卖股票的最佳时机II();
        int i = clazz.maxProfit(prices);
        assert i == 0;
    }
}
