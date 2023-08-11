package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author ZhangYao
 * @className 单词规律
 * @description https://leetcode.cn/problems/word-pattern/
 * @date Create in 14:28 2023/8/11
 */
public class 单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        HashMap<Character, String> p2sMap = new HashMap<>();
        if (s1.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            // 如果在map中
            if (p2sMap.containsKey(pattern.charAt(i))) {
                // 判断是否相等
                if (!Objects.equals(p2sMap.get(pattern.charAt(i)), s1[i])) {
                    return false;
                }
            }
            // 如果不在map中
            else {
                if (p2sMap.containsValue(s1[i])) {
                    return false;
                } else {
                    p2sMap.put(pattern.charAt(i), s1[i]);
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        单词规律 clazz = new 单词规律();
        boolean b = clazz.wordPattern("abba", "dog cat cat dog");
        assert b;
    }

    @Test
    public void test2() {
        单词规律 clazz = new 单词规律();
        boolean b = clazz.wordPattern("abba", "dog cat cat fish");
        assert !b;
    }

    @Test
    public void test3() {
        单词规律 clazz = new 单词规律();
        boolean b = clazz.wordPattern("aaaa", "dog cat cat dog");
        assert !b;
    }
}
