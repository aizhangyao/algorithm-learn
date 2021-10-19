package com.aiz.nowcoder.practice;

import java.util.Stack;

/**
 * @ClassName NC76
 * @Description 用两个栈实现队列
 * @Author Yao
 * @Date Create in 11:07 下午 2021/10/18
 * @Version 1.0
 */
public class NC76 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 队列尾部插入
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 队列头部删除
     *
     * @return
     */
    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /*
    队列：先进先出
    栈：先进后出
     */

}
