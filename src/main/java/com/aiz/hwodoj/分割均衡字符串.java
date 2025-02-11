package com.aiz.hwodoj;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 分割均衡字符串
 * @description 分割均衡字符串 https://hydro.ac/d/HWODOJ/p/9
 * @date Create in 02:16 2025/2/8
 */
public class 分割均衡字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int xCount = 0, yCount = 0, count = 0;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c == 'X') {
                xCount++;
            }
            if (c == 'Y') {
                yCount++;
            }
            if (xCount == yCount) {
                count++;
                xCount = 0;
                yCount = 0;
            }
        }
        System.out.println(count);
    }
}
