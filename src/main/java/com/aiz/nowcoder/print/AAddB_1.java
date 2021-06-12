package com.aiz.nowcoder.print;

import java.util.*;


/**
 *
 * 链接：https://ac.nowcoder.com/acm/contest/5649/A
 * 来源：牛客网
 *
 * 计算a+b
 *
 * 输入描述:
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
 * 输出描述:
 * 输出a+b的结果
 *
 * 示例1
 * 输入
 * 1 5
 * 10 20
 * 输出
 * 6
 * 30
 */
public class AAddB_1 {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(a+b);
        }
    }

}
