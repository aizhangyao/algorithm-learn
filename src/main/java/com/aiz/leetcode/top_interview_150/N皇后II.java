package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className N皇后II
 * @description https://leetcode.cn/problems/n-queens-ii/
 * @date Create in 14:07 2023/8/30
 */
public class N皇后II {
    private int count = 0;

    public int totalNQueens(int n) {
        char[][] chessboards = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboards[i][j] = '.';
            }
        }
        // 回溯放置
        dfs(chessboards, 0);
        return count;
    }

    private void dfs(char[][] chessboards, int row) {
        int n = chessboards.length;
        // 可以放置
        if (row == n) {
            count++;
            return;
        }
        // row行col列
        for (int col = 0; col < n; col++) {
            if (!canPut(chessboards, row, col)) {
                continue;
            }
            chessboards[row][col] = 'Q';
            dfs(chessboards, row + 1);
            chessboards[row][col] = '.';
        }
    }

    /**
     * (row,col)位置是否可以放在chessboards
     */
    boolean canPut(char[][] chessboards, int row, int col) {
        int n = chessboards.length;
        // 列上方向
        for (int i = 0; i < n; i++) {
            if (chessboards[i][col] == 'Q') {
                return false;
            }
        }
        // 左上
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (chessboards[i][j] == 'Q') {
                return false;
            }
        }
        // 右上
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (chessboards[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int i = totalNQueens(4);
        assert i == 2;
    }

    @Test
    public void test2() {
        int i = totalNQueens(1);
        assert i == 1;
    }
}
