package com.aiz.nowcoder.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5649/H
 * 来源：牛客网
 *
 * 对输入的字符串进行排序后输出
 * 输入描述:
 * 输入有两行，第一行n
 *
 * 第二行是n个空格隔开的字符串
 * 输出描述:
 * 输出一行排序后的字符串，空格隔开，无结尾空格
 *
 * 示例1
 * 输入
 * 5
 * c d a bb e
 * 输出
 * a bb c d e
 */
public class StringSort_1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0;i < n; i++) {
                arr[i] = sc.next();
            }
            Arrays.sort(arr);
            for (int i = 0;i < n-1; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println(arr[n-1]);
        }
    }

}
