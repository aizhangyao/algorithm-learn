package com.aiz.nowcoder.print;

import java.util.*;
/**
 * 链接：https://ac.nowcoder.com/acm/contest/5649/B
 * 来源：牛客网
 *
 * 题目描述
 * 计算a+b
 *
 * 输入描述:
 * 输入第一行包括一个数据组数t(1 <= t <= 100)
 * 接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
 * 输出描述:
 * 输出a+b的结果
 *
 * 示例1
 * 输入
 * 2
 * 1 5
 * 10 20
 * 输出
 * 6
 * 30
 */
public class AAddB_2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int a=0,b=0;
        for(int i=0;i<l;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            System.out.println(a+b);
        }
    }

}
