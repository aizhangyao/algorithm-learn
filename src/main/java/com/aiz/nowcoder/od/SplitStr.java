package com.aiz.nowcoder.od;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className SplitStr
 * @description https://leetcode.cn/circle/discuss/niKSMZ/
 * @date Create in 09:48 2023/7/17
 */
public class SplitStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 3
        int k = sc.nextInt();
        String lineStr = sc.next();
        // 12abc, abCABc-4aB@
        String[] split = lineStr.split("-", 2);
        StringBuilder result = new StringBuilder();
        result.append(split[0]);
        char[] chars = split[1].toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '-') {
                temp.append(chars[i]);
                if (temp.length() == k) {
                    result.append('-' + converter(temp.toString()));
                    temp.delete(0, temp.length());
                }
            }
        }
        if (temp.length() > 0) {
            result.append('-' + temp.toString());
        }
        System.out.println(result);
    }

    private static String converter(String str) {
        int upSize = 0;
        int lowSize = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                upSize++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                lowSize++;
            }
        }
        if (upSize == lowSize) {
            return str;
        }
        return upSize > lowSize ? str.toUpperCase() : str.toLowerCase();
    }
}
