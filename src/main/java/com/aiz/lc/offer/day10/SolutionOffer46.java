package com.aiz.lc.offer.day10;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer46
 * @description 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @date Create in 15:19 2023/4/7
 */
public class SolutionOffer46 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，
     * 11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    public int translateNum(int num) {
        // 数字转字符数组
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = 1;
        if (chars.length > 1) {
            int n = (chars[0] - '0') * 10 + (chars[1] - '0');
            if (n > 9 && n < 26) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        // 12258
        for (int i = 2; i < chars.length; i++) {
            // 可以和前面合并
            int n = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (n > 9 && n < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }

    public int translateNum2(int num) {
        // 数字转字符数组
        char[] chars = String.valueOf(num).toCharArray();
        // dp[i] 长度为i的一个数字有多少种不同的翻译方法
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 12258
        for (int i = 2; i < chars.length + 1; i++) {
            // 可以和前面合并
            int n = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
            if (n > 9 && n < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length];
    }

    public static void main(String[] args) {
        int i = new SolutionOffer46().translateNum(12258);
        System.out.println(i);
        int j = new SolutionOffer46().translateNum(25);
        System.out.println(j);

        System.out.println(12258 / 10);
        System.out.println(11 / 10);
    }

    // 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

    /**
     * answer1 : 动态规划
     * answer2 : 滚动数字 todo
     */
}
