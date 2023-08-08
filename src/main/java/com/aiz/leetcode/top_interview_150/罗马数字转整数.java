package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author ZhangYao
 * @className 罗马数字转整数
 * @description https://leetcode.cn/problems/roman-to-integer/
 * @date Create in 13:48 2023/8/8
 */
public class 罗马数字转整数 {

    public int romanToInt1(String s) {
        HashMap map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 1);
            String subNext = s.substring(i + 1, i + 2);
            if ((int) map.get(sub) < (int) map.get(subNext)) {
                sum -= (int) map.get(sub);
            } else {
                sum += (int) map.get(sub);
            }
        }
        sum += (int) map.get(s.substring(s.length() - 1));
        return sum;
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preValue = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (preValue < value) {
                sum -= preValue;
            } else {
                sum += preValue;
            }
            preValue = value;
        }
        sum += preValue;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    @Test
    public void test() {
        罗马数字转整数 clazz = new 罗马数字转整数();
        int i = clazz.romanToInt("III");
        assert i == 3;
    }

    @Test
    public void test2() {
        罗马数字转整数 clazz = new 罗马数字转整数();
        int i = clazz.romanToInt("IV");
        assert i == 4;
    }

    @Test
    public void test3() {
        罗马数字转整数 clazz = new 罗马数字转整数();
        int i = clazz.romanToInt("IX");
        assert i == 9;
    }

    @Test
    public void test4() {
        罗马数字转整数 clazz = new 罗马数字转整数();
        int i = clazz.romanToInt("LVIII");
        // L = 50, V= 5, III = 3.
        assert i == 58;
    }

    @Test
    public void test5() {
        罗马数字转整数 clazz = new 罗马数字转整数();
        int i = clazz.romanToInt("MCMXCIV");
        // M = 1000, CM = 900, XC = 90, IV = 4.
        assert i == 1994;
    }
}
