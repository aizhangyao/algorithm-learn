package com.aiz.nowcoder.practice;

/**
 * @ClassName NC134
 * @Description 股票(无限次交易)
 * @Author Yao
 * @Date Create in 11:13 上午 2021/9/27
 * @Version 1.0
 */
public class NC134 {
    /**
     * 计算最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        // write code here
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if(profit > 0){
                sum += profit;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {5,4,3,2,1};
        int[] prices2 = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
    }
}
