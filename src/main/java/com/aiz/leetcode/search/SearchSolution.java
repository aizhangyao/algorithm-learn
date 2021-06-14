package com.aiz.leetcode.search;

/**
 * @ClassName SearchSolution
 * @Description 查找算法
 * @Author Yao
 * @Date Create in 10:20 下午 2021/6/14
 * @Version 1.0
 */
public class SearchSolution {

    /**
     * 1。顺序查找：在数组a[]中查找元素d，若查到则返回d在数组中的位置，否则为-1；其中n为数组待长度。
     *
     * @param d 待查找的元素
     * @param a 数组
     * @return d在数组a[]中的位置
     */
    public static int SequenceSearch(int d, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        // 1.顺序查找
        System.out.println(SequenceSearch(3, a));

        // 2.二分查找

    }
}
