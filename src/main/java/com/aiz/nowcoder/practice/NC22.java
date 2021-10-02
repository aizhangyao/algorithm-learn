package com.aiz.nowcoder.practice;

import java.util.Arrays;

/**
 * @ClassName NC22
 * @Description 合并两个有序的数组
 * @Author Yao
 * @Date Create in 10:43 上午 2021/9/29
 * @Version 1.0
 */
public class NC22 {

    /**
     * 给出一个整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
     * 数据范围：0<=n,m<=100, |Ai|<=100,|Bi|<=100,
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (i >= 0) {
            A[k--] = A[i--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }

//        int index = m + n - 1;
//        while (m > 0 && n > 0) {
//            if (A[m - 1] >= B[n - 1]) {
//                A[index] = A[m - 1];
//                m--;
//            } else {
//                A[index] = B[n - 1];
//                n--;
//            }
//            index--;
//        }
//        if (m == 0) {
//            for (int i = n - 1; i >= 0; i++) {
//                A[i] = B[i];
//            }
//        }
    }

    public static void test1() {
        int[] A = {1, 3, 5, 7, 9, 0, 0, 0, 0};
        int m = 5;
        int[] B = {2, 4, 6, 8};
        int n = 4;
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    public static void test2() {
        int[] A = {};
        int m = 0;
        int[] B = {9};
        int n = 1;
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
