package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author ZhangYao
 * @className 同构字符串
 * @description https://leetcode.cn/problems/isomorphic-strings/
 * @date Create in 13:48 2023/8/11
 */
public class 同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
            if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println("哈哈".length());
        同构字符串 clazz = new 同构字符串();
        boolean isomorphic = clazz.isIsomorphic("egg", "add");
        assert isomorphic;
    }

    @Test
    public void test2() {
        同构字符串 clazz = new 同构字符串();
        boolean isomorphic = clazz.isIsomorphic("foo", "bar");
        assert !isomorphic;
    }

    @Test
    public void test3() {
        同构字符串 clazz = new 同构字符串();
        boolean isomorphic = clazz.isIsomorphic("paper", "title");
        assert isomorphic;
    }

    @Test
    public void test4() {
        同构字符串 clazz = new 同构字符串();
        boolean isomorphic = clazz.isIsomorphic("badc", "baba");
        assert !isomorphic;
    }
}
