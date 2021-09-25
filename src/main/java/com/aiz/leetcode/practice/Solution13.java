package com.aiz.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution13
 * @Description 罗马数字转整数 https://leetcode-cn.com/problems/roman-to-integer/
 * @Author Yao
 * @Date Create in 11:03 下午 2021/9/21
 * @Version 1.0
 */
public class Solution13 {

    public int romanToInt(String s) {
        Map map = new HashMap<String, Integer>(1);
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

        int result = 0;

        return result;
    }
}
