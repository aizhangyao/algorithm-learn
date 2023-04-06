package com.aiz.lc.offer.day03;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer58
 * @description 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @date Create in 10:01 2023/4/6
 */
public class SolutionOffer58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
