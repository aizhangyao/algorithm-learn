package com.aiz.leetcode.practice;

/**
 * @className 交换后字典序最小的字符串
 * @description https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/description/
 * @date Create in 23:37 2024/10/30
 */
public class 交换后字典序最小的字符串 {
    public String getSmallestString(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1] && chars[i] % 2 == chars[i + 1] % 2) {
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;
                break;
            }
        }
        return new String(chars);
    }
}
