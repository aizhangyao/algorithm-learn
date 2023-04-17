package com.aiz.lc.offer.day13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer58
 * @description 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @date Create in 16:33 2023/4/14
 */
public class SolutionOffer58 {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    public String reverseWords(String s) {
        char nullChar = ' ';
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        int right = s.length() - 1, left = right;
        StringBuilder stringBuilder = new StringBuilder();
        while (left > 0) {
            if (s.charAt(right) == nullChar) {
                right--;
                left--;
                continue;
            }
            if (s.charAt(left) == nullChar) {
                stringBuilder.append(s, left + 1, right + 1);
                stringBuilder.append(nullChar);
                right = left;
            }
            left--;
        }
        if (s.charAt(left) != nullChar) {
            stringBuilder.append(s, left, right + 1);
        }
        return stringBuilder.toString().trim();
    }


    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        SolutionOffer58 solutionOffer58 = new SolutionOffer58();
        System.out.println(solutionOffer58.reverseWords("hello world"));
        System.out.println(solutionOffer58.reverseWords("the sky is blue"));
        System.out.println(solutionOffer58.reverseWords("   a   b "));
        // System.out.println(solutionOffer58.reverseWords("a"));
        System.out.println(solutionOffer58.reverseWords("a good   example"));
        System.out.println(solutionOffer58.reverseWords("I am a student."));
    }

    /**
     * answer1 : 双指针
     * answer2 : api
     */

}
