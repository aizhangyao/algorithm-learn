package com.aiz.lc.offer.day08;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer63
 * @description 剑指 Offer 63. 股票的最大利润
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/description/
 * @date Create in 10:57 2023/4/7
 */
public class SolutionOffer63 {
    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     */

    public int maxProfit(int[] prices) {
        // 没有卖出的可能性
        if (prices.length <= 1) {
            return 0;
        }
        // 定义状态，第i天卖出的最大收益
        int[] dp = new int[prices.length];
        // 初始边界
        dp[0] = 0;
        // 成本
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            // 选择较小的成本买入
            cost = Math.min(cost, prices[i]);
        }
        return dp[prices.length - 1];
    }

    /**
     * 更符合人思维办法 假设最开始利润为0，只要你买入，你就要花钱，钱就要消失，也就是-price，
     * 所以我们希望花钱尽量小，来得到更大利润，需要维护一个buy希望记录最大值 也就是-price，代表花钱花得少，
     * 如果要卖出，相当于你会把现在股票价格收入囊中，你的钱会增加也就是+price，
     * 而你希望卖出后钱尽量大，所以就要维护一个maxProfit记录最大，
     * 故有 buy = Math.max(buy,-price); sell = Math.max(sell,buy+price);
     * 代码如下：
     */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }

    /**
     * answer1 : 动态规划
     * answer2 : 快慢指针 todo
     */
}
