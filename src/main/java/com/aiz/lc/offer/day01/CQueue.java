package com.aiz.lc.offer.day01;

import java.util.Stack;

/**
 * @author ZhangYao
 * @version 1.0
 * @className CQueue
 * @description 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @date Create in 10:35 2023/4/4
 */
public class CQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * 栈先进后出
     * 队列先进先出
     */
    // inStack a b c d e f
    // outStack f e d c b a
    public CQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }

    /**
     * 队列尾部插入
     */
    public void appendTail(int value) {
        inStack.push(value);
    }

    /**
     * 队列头部删除
     * 若队列中没有元素，deleteHead 操作返回 -1
     */
    public int deleteHead() {
        if (outStack.empty()) {
            if (inStack.empty()) {
                return -1;
            }
            // in->out
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

}
