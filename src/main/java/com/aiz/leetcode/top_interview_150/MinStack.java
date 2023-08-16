package com.aiz.leetcode.top_interview_150;

import java.util.Stack;

/**
 * @author ZhangYao
 * @className 最小栈
 * @description https://leetcode.cn/problems/min-stack/
 * @date Create in 11:12 2023/8/16
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.pop()));
    }

    void pop() {
        stack.pop();
        minStack.pop();
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return minStack.peek();
    }
}
