package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 买卖股票的最佳时机III
 * @description https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @date Create in 22:34 2024/4/14
 */
public class 买卖股票的最佳时机III {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        买卖股票的最佳时机III m = new 买卖股票的最佳时机III();

        assert 6 == m.maxProfit(prices);
    }

    @Test
    public void test2() {
        int[] prices = {1, 2, 3, 4, 5};

        买卖股票的最佳时机III m = new 买卖股票的最佳时机III();

        assert 4 == m.maxProfit(prices);
    }

    @Test
    public void test3() {
        int[] prices = {7, 6, 4, 3, 1};

        买卖股票的最佳时机III m = new 买卖股票的最佳时机III();

        assert 0 == m.maxProfit(prices);
    }

    @Test
    public void test4() {
        int[] prices = {1};

        买卖股票的最佳时机III m = new 买卖股票的最佳时机III();

        assert 0 == m.maxProfit(prices);
    }

    @Test
    public void test5() {
        int[] prices = {6, 1, 3, 2, 4, 7};

        买卖股票的最佳时机III m = new 买卖股票的最佳时机III();

        assert 7 == m.maxProfit(prices);
    }

    @Test
    public void test6() {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};

        买卖股票的最佳时机III m = new 买卖股票的最佳时机III();

        assert 13 == m.maxProfit(prices);
    }
}
