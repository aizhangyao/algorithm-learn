package com.aiz.leetcode.practice;

import java.util.Stack;

/**
 * @ClassName Solution20
 * @Description 有效的括号
 * @Author Yao
 * @Date Create in 11:54 下午 2021/9/27
 * @Version 1.0
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
