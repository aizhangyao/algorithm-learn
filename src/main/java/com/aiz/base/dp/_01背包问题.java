package com.aiz.base.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className _01背包问题
 * @description 01背包问题
 * @date Create in 17:47 2023/8/21
 */
public class _01背包问题 {
    /**
     * 0-1背包问题描述
     * 有n件物品，每件物品的体积为w[n],价值为c[n]。
     * 现有一个容量为V的背包，问如何选取物品放入背包，使得背包内物品的总价值最大。其中每件物品只有1件。
     */

    /**
     * 为什么是0-1背包，因为每件物品要么选，要么不选，不存在选几件的选项。
     */
    @Test
    public void test() {
        // 体积
        int[] w = {2, 3, 4, 5};
        // 价值
        int[] c = {3, 4, 5, 6};
        // 背包容量
        int V = 11;
        // 物品种类
        int N = w.length;
        // dp[i][j]在体积j的限制下，在w[0]-w[i]中选所能获取的最大价值
        // 0<=i<=N,0<=j<=V
        // i=1,j=1时，就是 体积为1的时候决策完第1件物品 的最大价值
        // 不同的(i,j)对叫做不同的状态，因此每一个dp[i][j]都是在相应状态下的最优值
        int[][] dp = zeroOnePack(N, V, w, c);

        System.out.println("最大价值" + dp[N][V]);
        List choose = flashBack(N, V, w, dp);
        for (int i = choose.size() - 1; i >= 0; i--) {
            // 选择第choose.get(i)件
            System.out.print(choose.get(i));
        }
        System.out.println();
    }

    /**
     * 求解0-1背包
     *
     * @param N 物品种类
     * @param V 背包容量
     * @param w 物品重量
     * @param c 物品价值
     */
    private int[][] zeroOnePack(int N, int V, int[] w, int[] c) {
        int[][] dp = new int[N + 1][V + 1];
        // 决策完第0件物品，无论体积v多大，获得的总价值总为0。
        for (int v = 0; v <= V; v++) {
            dp[0][v] = 0;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        // i代表第i个物品,j代表j体积的限制下
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                // 可以选物品w[i-1]
                if (w[i - 1] <= j) {
                    // max(选，不选)
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + c[i - 1], dp[i - 1][j]);
                }
                // 不可以选物品w[i-1]
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }

    /**
     * 回溯找方案
     */
    private List flashBack(int N, int V, int[] w, int[][] dp) {
        List list = new ArrayList<>();
        int i = N, j = V;
        while (i != 0) {
            // 没有选择第i件
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            }
            // 选第i件
            else {
                i--;
                list.add(i);
                j = j - w[i];
            }
        }
        return list;
    }

}
