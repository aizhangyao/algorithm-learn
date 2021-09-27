package com.aiz.nowcoder.practice;

/**
 * @ClassName NC107
 * @Description 寻找峰值
 * @Author Yao
 * @Date Create in 10:17 上午 2021/9/27
 * @Version 1.0
 */
public class NC107 {
    /**
     * 寻找最后的山峰
     * nums[-1] = nums[n] = -∞。
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public static int solve(int[] a) {
        // write code here
        if (a == null || a.length == 0) {
            return -1;
        }
        for (int i = a.length - 1; i >= 1; i--) {
            if (a[i] >= a[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 2, 7, 8, 4};
        System.out.println(solve(a));

        int[] a1 = {1,2,3,4,5,6,7,8,9};
        System.out.println(solve(a1));
    }
}
