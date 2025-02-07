package com.aiz.leetcode.practice;

import org.junit.jupiter.api.Test;

/**
 * @Description 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Date Create in 5:31 下午 2021/10/1
 * @Version 1.0
 */
public class 买卖股票的最佳时机II {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int dayProfit = prices[i] - prices[i - 1];
            if (dayProfit > 0) {
                profit += dayProfit;
            }
        }
        return profit;
    }

    @Test
    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
