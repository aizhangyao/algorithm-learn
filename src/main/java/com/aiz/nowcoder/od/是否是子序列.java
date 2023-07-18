package com.aiz.nowcoder.od;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 是否是子序列
 * @description https://www.nowcoder.com/questionTerminal/5382ff24fbf34a858b15f93e2bd85307
 * @date Create in 17:52 2023/7/18
 */
public class 是否是子序列 {
    /**
     * 给定两个字符串 s和 t ，判断 s是否为 t 的子序列。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        if (s.length() > t.length()) {
            System.out.println(false);
        }
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        System.out.println(sIndex == s.length());
    }
    /**
     * 快慢指针
     */
}
