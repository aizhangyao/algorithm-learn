package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * @author ZhangYao
 * @className 简化路径
 * @description https://leetcode.cn/problems/simplify-path/
 * @date Create in 10:10 2023/8/16
 */
public class 简化路径 {
    /**
     * 栈解决,把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.
     */
    public String simplifyPath(String path) {
        // ../ 返回上一级 弹出栈顶
        // ./ 当前目录本身 不管他
        // // 视为单个斜杠
        // ... 文件目录名称 直接入栈
        String[] split = path.split("/");
        Stack<String> stack = new Stack();
        for (String str : split) {
            if (str.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            if (!str.equals(".") && !str.equals("..") && !str.equals("")) {
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        简化路径 clazz = new 简化路径();
        String s = clazz.simplifyPath("/home/");
        assert Objects.equals(s, "/home");
    }

    @Test
    public void test2() {
        简化路径 clazz = new 简化路径();
        String s = clazz.simplifyPath("/../");
        assert Objects.equals(s, "/");
    }

    @Test
    public void test3() {
        简化路径 clazz = new 简化路径();
        String s = clazz.simplifyPath("/home//foo/");
        assert Objects.equals(s, "/home/foo");
    }

    @Test
    public void test4() {
        简化路径 clazz = new 简化路径();
        String s = clazz.simplifyPath("/a/./b/../../c/");
        assert Objects.equals(s, "/c");
    }
}
