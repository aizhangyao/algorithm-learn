package com.aiz.leetcode.practice;

/**
 * @ClassName Solution122
 * @Description 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author Yao
 * @Date Create in 5:31 下午 2021/10/1
 * @Version 1.0
 */
public class Solution122 {
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

    public static void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
