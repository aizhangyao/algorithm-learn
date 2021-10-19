package com.aiz.leetcode.exam.v20211016;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Yao
 * @Date Create in 11:42 下午 2021/10/16
 * @Version 1.0
 */
public class Solution {

    public static int minMovesToSeat(int[] seats, int[] students) {


        /**
         * seats = [4,1,5,9], students = [1,3,2,6]
         * - 第一位学生不移动。seats = [4,1,5,9], students = [1,3,2,6]
         * - 第二位学生从位置 3 移动到位置 4 ，移动 1 次。seats = [4,1,5,9], students = [1,3,2,6]
         * - 第三位学生从位置 2 移动到位置 5 ，移动 3 次。
         * - 第四位学生从位置 6 移动到位置 9 ，移动 3 次。
         */
        int count = 0;
        for (int i = 0; i < students.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
