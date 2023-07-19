package com.aiz.nowcoder.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 字符串ASC码偏移_加密
 * @description https://www.codeleading.com/article/89584473419/
 * @date Create in 15:16 2023/7/19
 */
public class 字符串ASC码偏移_加密 {

    /**
     * a[0]=1,a[1]=2,a[2]=4,当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            data.add(sc.next());
        }
        int[] a = new int[50];
        initialize(a);

        for (String datum : data) {
            char[] chars = datum.toCharArray();
            String str = "";
            for (int i = 0; i < chars.length; i++) {
                str += offset(chars[i], a[i]);
            }
            System.out.println(str);
        }
    }

    private static void initialize(int[] a) {
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }
    }

    private static char offset(char c, int offset) {
        return (char) (c + offset);
    }
}
/*
1
abcdef
 */
