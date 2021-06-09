package com.aiz.nowcoder.print;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5649/D
 * 来源：牛客网
 *
 * 计算一系列数的和
 *
 * 输入描述:
 * 输入数据包括多组。
 * 每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
 * 接下来n个正整数,即需要求和的每个正整数。
 * 输出描述:
 * 每组数据输出求和的结果
 *
 * 示例1
 * 输入
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 0
 * 输出
 * 10
 * 15
 */
public class AAddB_4 {

    public static void main(String[] arge){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int i=0;
        int sum=0;
        while(l!=0 && i<l){
            sum+=sc.nextInt();
            i++;
            if(i==l){
                l=sc.nextInt();
                System.out.println(sum);
                sum=0;
                i=0;
            }
        }
    }

}
