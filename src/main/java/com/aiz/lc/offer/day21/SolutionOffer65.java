package com.aiz.lc.offer.day21;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer65
 * @description 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @date Create in 22:18 2023/5/4
 */
public class SolutionOffer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int add2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add2(a ^ b, (a & b) << 1);
    }

    /**
     * 0 + 0 = 0
     * 0 + 1 = 1
     * 1 + 0 = 1
     * 1 + 1 = 0 (进位)
     * <p>
     * a    b   (a ^ b)     (a & b)
     * 0    0   0           0
     * 0    1   1           0
     * 1    0   1           0
     * 1    1   0           1
     * answer1 :  a+b的结果等于a^b+(a&b)<<1
     */

    public static void main(String[] args) {
        System.out.println("0 ^ 0 = " + (0 ^ 0));
        System.out.println("0 ^ 1 = " + (0 ^ 1));
        System.out.println("1 ^ 0 = " + (1 ^ 0));
        System.out.println("1 ^ 1 = " + (1 ^ 1));
        System.out.println();
        System.out.println("0 & 0 = " + (0 & 0));
        System.out.println("0 & 1 = " + (0 & 1));
        System.out.println("1 & 0 = " + (1 & 0));
        System.out.println("1 & 1 = " + (1 & 1));
    }
}
