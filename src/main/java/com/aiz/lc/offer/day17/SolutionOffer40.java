package com.aiz.lc.offer.day17;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer40
 * @description 剑指 Offer 40. 最小的k个数
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 * @date Create in 12:35 2023/4/18
 */
public class SolutionOffer40 {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        // 选择排序
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            result[i] = arr[minIndex];
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionOffer40 solutionOffer40 = new SolutionOffer40();
        int[] arr = new int[]{3, 2, 1};
        int[] leastNumbers = solutionOffer40.getLeastNumbers(arr, 2);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.print(leastNumbers[i] + " ");
        }
    }

    /**
     * answer1 : 排序
     */
}
