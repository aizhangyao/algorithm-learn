package com.aiz.lc.offer.day01;

import java.util.Stack;

/**
 * @author ZhangYao
 * @version 1.0
 * @className MinStack
 * @description 剑指 Offer 30. 包含min函数的栈
 * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
 * https://leetcode.cn/study-plan/lcof/
 * @date Create in 17:34 2023/4/4
 */
public class MinStack {

    private Stack<Integer> stack;
    /**
     * 辅助栈
     */
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 将元素x推入堆栈。
     */
    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    /**
     * 删除堆栈顶部的元素。
     */
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    /**
     * 获取堆栈顶部的元素。
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取堆栈中的最小元素。
     */
    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回 -3.
        System.out.println(minStack.min());
        minStack.pop();
        // 返回 0.
        System.out.println(minStack.top());
        // 返回 -2.
        System.out.println(minStack.min());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */