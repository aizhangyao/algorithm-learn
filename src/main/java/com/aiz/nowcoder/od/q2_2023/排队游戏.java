package com.aiz.nowcoder.od.q2_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 排队游戏
 * @description https://www.online1987.com/排队游戏/
 * @date Create in 14:13 2023/8/16
 */
public class 排队游戏 {
    /**
        输入描述

        输入有三行：
        第一行为n,m,k,空格隔开，分别表示班级总人数，刺头人数，最大不满程度k。
        第二行为刺头所在位置(从0开始，即排队数组的下标，比如1代表队伍中第2个同学是刺头)，位置的数组也是排序的。
        第三行有n个数，空格隔开，表示老师排好的队中每个人的能力值，其中非刺头同学一定按照能力值从小到大排好序的。


        新来的老师给班里的同学排一个队。
        每个学生有一个影力值。
        一些学生是刺头，不会听老师的话，自己选位置，非刺头同学在剩下的位置按照能力值从小到大排。
        对于非刺头同学，如果发现他前面有能力值比自己高的同学，他不满程度就增加，增加的数量等于前面能力值比他大的同学的个数。
        刺头不会产生不满。
        如果整个班级累计的不满程度超过k，那么老师就没有办法教这个班级了。

        输出描述
        0 表示老师可以继续教这个班级
        1 表示老师无法继续教这个班级

        示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
        输入
        4 2 3
        0 1
        1810 1809 1801 1802

        输出
        1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 班级总人数
        int n = sc.nextInt();
        // 刺头人数
        int m = sc.nextInt();
        // 最大不满程度
        int k = sc.nextInt();

        // 刺头所在位置
        List<Integer> sbIndexList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sbIndexList.add(sc.nextInt());
        }
        // 每个人的能力值
        List<Integer> abilities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            abilities.add(sc.nextInt());
        }
        int unhappy = 0;
        for (int i = 0; i < n; i++) {
            // 刺头
            if(sbIndexList.contains(i)){
                // 不需要加unhappy
            }
            // 非刺头
            else {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    // 刺头j > 本次不是刺头的
                    if(abilities.get(j) > abilities.get(i)){
                        count++;
                    }
                }
                unhappy+=count;
            }
        }
        System.out.println(unhappy > k ? 1 : 0);
    }
}
