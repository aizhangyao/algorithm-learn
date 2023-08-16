package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ZhangYao
 * @className 逆波兰表达式求值
 * @description https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @date Create in 11:33 2023/8/16
 */
public class 逆波兰表达式求值 {
    /**
     * 遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
     */
    public int evalRPN2(String[] tokens) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b + a));
                    break;
                case "-":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b - a));
                    break;
                case "*":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b * a));
                    break;
                case "/":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b / a));
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    @Test
    public void test() {
        逆波兰表达式求值 clazz = new 逆波兰表达式求值();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int i = clazz.evalRPN(tokens);
        assert i == 9;
    }

    @Test
    public void test2() {
        逆波兰表达式求值 clazz = new 逆波兰表达式求值();
        String[] tokens = {"4", "13", "5", "/", "+"};
        int i = clazz.evalRPN(tokens);
        assert i == 6;
    }

    @Test
    public void test3() {
        逆波兰表达式求值 clazz = new 逆波兰表达式求值();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = clazz.evalRPN(tokens);
        assert i == 22;
    }

}
