//package com.aiz.leetcode.array;
//
//import org.junit.Test;
//
///**
// * @ClassName SolutionT1343
// * @Description https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
// * @Author Administrator
// * @Date Create in 20:39 2020/6/30 0030
// * @Version 1.0
// */
//public class SolutionT203 {
//
//    /**
//     * 我自己写的
//     *
//     * @param arr
//     * @param k
//     * @param threshold
//     * @return
//     */
//    public int numOfSubarrays(int[] arr, int k, int threshold) {
//        int count = 0;
//        int compareNum = k * threshold;
//        for (int i = 0; i <= arr.length - k; i++) {
//            int sum = 0;
//            int c = 0;
//            while (c < k) {
//                sum += arr[i + c];
//                c++;
//            }
//            if (sum >= compareNum) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//
//    @Test
//    public void test_1() {
//        SolutionT203 s = new SolutionT203();
//        int[] arr_1 = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
//        int k_1 = 3;
//        int threshold_1 = 4;
//
//        // assertEquals(3, s.numOfSubarrays(arr_1, k_1, threshold_1));
//    }
//
//
//}
//
///**
// * 个人即时感悟--2020/6/30
// * 1.概念理解：子数组是从母串截取一部分
// * 2.步骤：从第下标为第0开始 偏移k位计算数组和与k*threshold比较
// * <p>
// * 通过运行发现空间消耗最优，但是时间消耗很差
// */