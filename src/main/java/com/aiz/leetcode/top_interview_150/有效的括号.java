package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author ZhangYao
 * @className 有效的括号
 * @description https://leetcode.cn/problems/valid-parentheses/
 * @date Create in 09:50 2023/8/16
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty() || (char) stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || (char) stack.pop() != '[') {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || (char) stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        有效的括号 clazz = new 有效的括号();
        boolean valid = clazz.isValid("()");
        assert valid;
    }

    @Test
    public void test1() {
        有效的括号 clazz = new 有效的括号();
        boolean valid = clazz.isValid("()[]{}");
        assert valid;
    }

    @Test
    public void test2() {
        有效的括号 clazz = new 有效的括号();
        boolean valid = clazz.isValid("(]");
        assert !valid;
    }
}
