package com.aiz.lc.offer.day09;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer47
 * @description 剑指 Offer 47. 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @date Create in 13:59 2023/4/7
 */
public class SolutionOffer47 {


    /**
     * m*n
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new SolutionOffer47().maxValue(grid));
    }

    /**
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     */

    /**
     * answer1 : 动态规划
     */


}
