package com.aiz.nowcoder.practice;

/**
 * @ClassName NC141
 * @Description 判断回文
 * @Author Yao
 * @Date Create in 1:14 上午 2021/9/27
 * @Version 1.0
 */
public class NC141 {

    public static boolean judge(String str) {
        // write code here
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(judge("88099"));
    }
}
