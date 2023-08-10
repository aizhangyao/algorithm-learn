package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 旋转图像
 * @description https://leetcode.cn/problems/rotate-image/
 * @date Create in 10:56 2023/8/10
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 左右对称
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        // <左下-右上>对角线
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }
    }

    @Test
    public void test() {
        旋转图像 clazz = new 旋转图像();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        clazz.rotate(matrix);
        int[][] expectedResult = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                assert matrix[i][j] == expectedResult[i][j];
            }
        }
    }

    @Test
    public void test2() {
        /*
        05, 01, 09, 11,
        02, 04, 08, 10,
        13, 03, 06, 07,
        15, 14, 12, 16
        ------左右--------->
        11, 09, 01, 05,
        10, 08, 04, 02,
        07, 06, 03, 13,
        16, 12, 14, 15
        --------<左下-右上>对角线------->
        15, 13, 02, 05,
        14, 03, 04, 01,
        12, 06, 08, 09,
        16, 07, 10, 11
        */
        旋转图像 clazz = new 旋转图像();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        clazz.rotate(matrix);
        int[][] expectedResult = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                assert matrix[i][j] == expectedResult[i][j];
            }
        }
    }

}