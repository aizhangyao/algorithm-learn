package com.aiz.nowcoder.practice;

/**
 * @ClassName NC32
 * @Description 求平方根
 * @Author Yao
 * @Date Create in 10:40 下午 2021/9/25
 * @Version 1.0
 */
public class NC32 {
    /**
     * 计算并返回 x 的平方根（向下取整）
     *
     * @param x int整型
     * @return int整型
     */
    public static int sqrt(int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left < right) {
            long mid = (left + right) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = (int) mid;
            } else {
                left = (int) mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(1518991037));
    }
}
