package com.aiz.nowcoder.practice;

/**
 * @ClassName NC103
 * @Description 反转字符串
 * @Author Yao
 * @Date Create in 11:35 上午 2021/9/23
 * @Version 1.0
 */
public class NC103 {
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public static String solve(String str) {
        // write code here
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i >= 0 ; i--) {
            result.append(chars[i]);
        }
        return result.toString();
        // return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("abcd"));
    }
}
