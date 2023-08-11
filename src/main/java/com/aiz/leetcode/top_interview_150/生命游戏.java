package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 生命游戏
 * @description https://leetcode.cn/problems/game-of-life/
 * @date Create in 11:18 2023/8/11
 */
public class 生命游戏 {

    /**
     * 复制原数组进行模拟
     */
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] copyBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oneCount = 0, index = 0;
                while (index < directions.length) {
                    int newRow = i + directions[index][0], newColumn = j + directions[index][1];
                    if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n) {
                        if (copyBoard[newRow][newColumn] == 1) {
                            oneCount++;
                        }
                    }
                    index++;
                }
                if (board[i][j] == 1) {
                    if (oneCount < 2 || oneCount > 3) {
                        board[i][j] = 0;
                    }
                }
                if (board[i][j] == 0 && oneCount == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    @Test
    public void test() {
        生命游戏 clazz = new 生命游戏();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        clazz.gameOfLife(board);
        int[][] expectedResult = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
        BaseTool.equals(board, expectedResult);
    }

    @Test
    public void test2() {
        生命游戏 clazz = new 生命游戏();
        int[][] board = {{1, 1}, {1, 0}};
        clazz.gameOfLife(board);
        int[][] expectedResult = {{1, 1}, {1, 1}};
        BaseTool.equals(board, expectedResult);
    }

    /**
     * 如果想不使用额外的数组空间，可以引入复合状态。
     * 已经存在的状态：
     * 0：死细胞
     * 1：活细胞
     * -1：代表从活到死
     * 2：代表从死到货
     *
     * 遍历一遍最后设为完成状态之后，再把复合状态还原回来。
     */
}
