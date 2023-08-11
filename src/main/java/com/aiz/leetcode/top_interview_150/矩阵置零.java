package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 矩阵置零
 * @description https://leetcode.cn/problems/set-matrix-zeroes/
 * @date Create in 16:49 2023/8/10
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        // 记录第几行上是否有0
        boolean[] rows = new boolean[matrix.length];
        // 记录第几列上是否有0
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        矩阵置零 clazz = new 矩阵置零();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        clazz.setZeroes(matrix);
        int[][] expectedResult = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        BaseTool.equals(matrix, expectedResult);
    }

    @Test
    public void test2() {
        矩阵置零 clazz = new 矩阵置零();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        clazz.setZeroes(matrix);
        int[][] expectedResult = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        BaseTool.equals(matrix, expectedResult);
    }
}
