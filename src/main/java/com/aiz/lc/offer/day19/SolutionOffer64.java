package com.aiz.lc.offer.day19;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer64
 * @description Offer 64. 求1+2+…+n
 * https://leetcode.cn/problems/qiu-12n-lcof/
 * @date Create in 23:26 2023/4/23
 */
public class SolutionOffer64 {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return sumNums(n - 1) + n;
    }

    /**
     * answer1 : 递归
     */
}
