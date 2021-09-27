package com.aiz.nowcoder.practice;

/**
 * @ClassName NC7
 * @Description 买卖股票的最好时机
 * @Author Yao
 * @Date Create in 11:04 下午 2021/9/25
 * @Version 1.0
 */
public class NC7 {

    /**
     * 假设你有一个数组，其中第 i 个元素是股票在第i天的价格。
     * 你可以买入一次股票和卖出一次股票（并非每天都可以买入或卖出一次，总共只能买入和卖出一次），问能获得的最大收益是多少。
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        /**
         * 1.确定状态。
         * 2.找到转移公式。
         * 3.确定初始条件以及边界条件。
         * 4.计算结果。
         */
        /**
         1.定义一个二维数组dp[length][2]，其中dp[i][0]表示第i+1天结束的时候的没有持有股票的最大利润，其中dp[i][0]表示第i+1天结束的时候持有股票的最大利润。(i从0开始)
         2.
         dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
         dp[i][1]=max(dp[i-1][1],-prices[i]);
         */
        // write code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 4, 2};
        System.out.println(maxProfit(prices));
    }

    /**
     * 1.动态规划。
     * 2.双指针。
     * 3.单调栈。
     */

}
