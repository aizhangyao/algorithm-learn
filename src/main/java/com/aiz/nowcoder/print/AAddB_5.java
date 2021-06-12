package com.aiz.nowcoder.print;


import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5649/E
 * 来源：牛客网
 *
 * 计算一系列数的和
 *
 * 输入描述:
 * 输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
 * 接下来t行, 每行一组数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 * 输出描述:
 * 每组数据输出求和的结果
 *
 * 示例1
 * 输入
 * 2
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 输出
 * 10
 * 15
 */
public class AAddB_5 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++){
            int n = sc.nextInt();
            int sum = 0;
            for(int j =0; j<n; j++){
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
