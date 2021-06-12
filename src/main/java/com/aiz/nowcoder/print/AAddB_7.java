package com.aiz.nowcoder.print;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5649/G
 * 来源：牛客网
 *
 * 计算一系列数的和
 * 输入描述:
 * 输入数据有多组, 每行表示一组输入数据。
 *
 * 每行不定有n个整数，空格隔开。(1 <= n <= 100)。
 * 输出描述:
 * 每组数据输出求和的结果
 *
 * 示例1
 * 输入
 * 1 2 3
 * 4 5
 * 0 0 0 0 0
 * 输出
 * 6
 * 9
 * 0
 */
public class AAddB_7 {

    public static void main(String[] arge){
        Scanner sc=new Scanner(System.in);

        while(sc.hasNextLine()){
            String str=sc.nextLine();
            String[] ch=str.split(" ");
            int sum=0;
            for(String s : ch){
                sum+=Integer.parseInt(s);
            }
            System.out.println(sum);
        }

    }
}
