package com.aiz.nowcoder.practice;

import java.util.ArrayList;

/**
 * @ClassName NC38
 * @Description 螺旋矩阵
 * @Author Yao
 * @Date Create in 11:41 上午 2021/9/23
 * @Version 1.0
 */
public class NC38 {

    /**
     * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
     * 数据范围：0<=n,m<=10，矩阵中任意元素都满足|val|<=100
     * 要求：空间复杂度o(nm) ，时间复杂度o(nm)
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }


        boolean direction = true;
        for (int m = 0; m < matrix.length; m++) {
            if (direction) {
                for (int n = 0; n < matrix[m].length; n++) {
                    result.add(matrix[m][n]);
                }
            } else {
                for (int n = matrix[m].length - 1; n >= 0; n--) {
                    result.add(matrix[m][n]);
                }
            }
            direction = !direction;
        }
        return result;
    }

    /**
     * 输入：[[1,2,3],
     * [4,5,6],
     * [7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        ArrayList<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
}
