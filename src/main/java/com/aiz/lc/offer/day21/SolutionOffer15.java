package com.aiz.lc.offer.day21;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer15
 * @description 剑指 Offer 15. 二进制中1的个数
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @date Create in 21:53 2023/5/4
 */
public class SolutionOffer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        // 当检查第 i 位时，我们可以让 n 与 2^i 进行与运算，当且仅当 n 的第 i 位为 1 时，运算结果不为 0。
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeight3(int n) {
        // n & (n-1)，其运算结果是把n的二进制位中的最低位1变成0
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    /**
     * answer1 : 循环检查二进制位
     * answer2 :位运算优化
     */
}
