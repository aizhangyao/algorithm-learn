package com.aiz;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @version 1.0
 * @className NC
 * @description TODO
 * @date Create in 13:48 2023/4/10
 */
public class NC {
    public int f(int[] nums){
        // 1 2 3 4 3 2 1
        // 1 2 3 4 5 6 3 2 1
        int n = nums.length;
        int dp[] = new int[n];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

        }

        return 0;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

    }
}
