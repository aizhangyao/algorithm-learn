package com.aiz.lc.offer.day05;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer50
 * @description 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @date Create in 17:44 2023/4/6
 */
public class SolutionOffer50 {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     */
    public char firstUniqChar(String s) {
        // 考虑字典表
        // 'a'  97
        int[] dic = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            dic[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (dic[chars[i] - 'a'] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(new SolutionOffer50().firstUniqChar(str));
    }

    /**
     * answer1 : 字典
     * answer2 : 队列
     */
}
