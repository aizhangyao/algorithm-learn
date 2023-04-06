package com.aiz.lc.offer.day05;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer04
 * @description 剑指 Offer 04. 二维数组中的查找
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @date Create in 13:14 2023/4/6
 */
public class SolutionOffer04 {
    /**
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     */

    /**
     * 暴力解法
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                if (matrix[row][colum] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int colum = matrix[0].length;
        if (colum == 0) {
            return false;
        }
        // 当前位置[x,y]
        int x = 0, y = colum - 1;
        while (x < row && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else if (matrix[x][y] > target) {
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean numberIn2DArray = new SolutionOffer04().findNumberIn2DArray(matrix, 5);
        System.out.println(numberIn2DArray);

    }



    /**
     * answer1 : 暴力解法 两层for
     * answer2 : 二分查找 对每一层进行二分查找
     * answer3 : Z 字形查找，从右上角 (0,n−1) 进行搜索。(0,n-1)--->(m-1,0)，假设当前位置为(x,y)
     *          matrix[x][y] == target, 结束
     *          matrix[x][y] > target, 说明y列元素都大于target, y--
     *          matrix[x][y] < target, 说明x行元素都大于target, x++
     */

}
