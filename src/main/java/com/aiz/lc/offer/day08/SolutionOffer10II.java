package com.aiz.lc.offer.day08;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer10II
 * @description 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @date Create in 01:09 2023/4/7
 */
public class SolutionOffer10II {

    /**
     * 设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
     * <p>
     * 当为 1 级台阶： 剩 n−1 个台阶，此情况共有 f(n−1) 种跳法；
     * 当为 2 级台阶： 剩 n−2 个台阶，此情况共有 f(n−2) 种跳法。
     */
    public int numWays(int n) {
        final int MOD = 1000000007;
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % MOD;
            a = b;
            b = sum;
        }
        return a;
    }


    /**
     * answer1 : 动态规划 滚动数组
     */

}
