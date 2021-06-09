package com.aiz.nowcoder.print;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5649/J
 * 来源：牛客网
 *
 * 对输入的字符串进行排序后输出
 * 输入描述:
 * 多个测试用例，每个测试用例一行。
 * 每行通过,隔开，有n个字符，n＜100
 * 输出描述:
 * 对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
 *
 * 示例1
 * 输入
 * a,c,bb
 * f,dddd
 * nowcoder
 * 输出
 * a,bb,c
 * dddd,f
 * nowcoder
 */
public class StringSort_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()) {
            String[] str = reader.nextLine().split(",");
            Arrays.sort(str);
            for(int i=0;i<str.length;i++) {
                if(i==str.length-1)
                    System.out.print(str[i]);
                else
                    System.out.print(str[i]+",");
            }
            System.out.println();
        }
    }
}
