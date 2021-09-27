package com.aiz.nowcoder.practice;

/**
 * @ClassName NC65
 * @Description 斐波那契数列
 * @Author Yao
 * @Date Create in 11:47 下午 2021/9/25
 * @Version 1.0
 */
public class NC65 {
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

}
