package com.aiz.nowcoder.practice;

import java.util.Stack;

/**
 * @ClassName NC1
 * @Description 大数加法
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=196&&tqId=37176&rp=1&ru=/ta/job-code-total&qru=/ta/job-code-total/question-ranking
 * @Author Yao
 * @Date Create in 11:35 下午 2021/9/19
 * @Version 1.0
 */
public class NC1 {

    public static String solve(String s, String t) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? s.charAt(i--) - '0' : 0;
            carry += j >= 0 ? t.charAt(j--) - '0' : 0;
            stack.push(carry % 10);
            carry = carry / 10;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "123456";
        String t = "7890";
        System.out.println(solve(s, t));
    }
}
