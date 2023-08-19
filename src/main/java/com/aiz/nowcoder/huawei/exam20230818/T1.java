package com.aiz.nowcoder.huawei.exam20230818;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 食堂开餐时间
        // 3
        int N = in.nextInt();
        // 开餐前食堂已经准备好的盒饭份数
        // 14
        int M = in.nextInt();
        // 开餐时间内按时间顺序 每个单位时间进入食堂取餐人数
        // 10 4 5
        int[] p = new int[N];
        // 19
        for (int i = 0; i < N; i++) {
            p[i] = in.nextInt();
        }

        // 开始就不够
        if (M < p[0]) {
            return;
        }

        extracted(M, p);
    }

    private static void extracted(int M, int[] p) {

        // 单位时间做的最少份数
        int least = 0;
        for (int i = 0; i < p.length; i++) {
            // 第i时间开始 剩下r
            int r = M - p[i];
            // 如果不够
            if (r < 0) {
                // 本次少r份
                // 前面可以加i份
                // 每一次需要额外添加
                int t = (-r / i) + ((-r % i == 0) ? 0 : 1);
                // 一共需要添加 i次
                least = least + t;
                M = M + i * t + least;
            }
            // 够吃
            else {
                M = M + least;
            }
            M = M - p[i];
        }
        System.out.println(least);
    }

    @Test
    public void test() {
        extracted(5, new int[]{10,4,5,8,9});
    }


}
