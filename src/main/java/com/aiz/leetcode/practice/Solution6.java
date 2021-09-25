package com.aiz.leetcode.practice;

/**
 * @ClassName Solution6
 * @Description Z字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author Yao
 * @Date Create in 3:39 下午 2021/9/24
 * @Version 1.0
 */
public class Solution6 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * <p>
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int len = s.length();
        int numColumns = len % numRows == 0 ? len / numRows : len / numRows + 1;
        int[][] array = new int[numRows][numColumns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }



        return null;
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(str.length());
        convert(str,3);

        String str2 = "";
        System.out.println(str2.length());

    }

}
