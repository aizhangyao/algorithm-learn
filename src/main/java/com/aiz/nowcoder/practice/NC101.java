package com.aiz.nowcoder.practice;

/**
 * @ClassName NC101
 * @Description 缺失数字
 * @Author Yao
 * @Date Create in 10:34 上午 2021/9/27
 * @Version 1.0
 */
public class NC101 {
    /**
     * 从 0,1,2,...,n 这 n+1 个数中选择 n 个数，选择出的数字依然保持有序，找出这 n 个数中缺失的那个数，要求 O(n) 或 O(log(n)) 并尽可能小。
     * <p>
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public static int solve(int[] a) {
        // write code here
        int i = 0;
        while (i < a.length) {
            if (a[i] != i) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] a1 = {0, 1, 2, 3, 4};
        System.out.println(solve(a));
    }
}
