package com.aiz.nowcoder.practice;

/**
 * @ClassName NC57
 * @Description 反转数字
 * @Author Yao
 * @Date Create in 11:19 上午 2021/9/27
 * @Version 1.0
 */
public class NC57 {
    /**
     * 空间复杂度O(1)，时间复杂度O(len(x))
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        // write code here
        // 23
        if (x > Integer.MAX_VALUE / 10 || x < Integer.MIN_VALUE / 10) {
            return 0;
        }
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1147483649));
    }

}
