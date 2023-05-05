package com.aiz.base.search;

/**
 * @author Yao
 * @version 1.0
 * @className SearchSolution
 * @description 查找算法
 * @date Create in 10:20 下午 2021/6/14
 */
public class SearchSolution {

    /**
     * 1。顺序查找：在数组a[]中查找元素d，若查到则返回d在数组中的位置，否则为-1；其中n为数组待长度。
     *
     * @param a     数组
     * @param n     数组长度
     * @param value 待查找的元素
     * @return value在数组a[]中的位置
     */
    public static int sequenceSearch(int[] a, int n, int value) {
        for (int i = 0; i < n; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 2。二分查找：前提保证元素必须是有序的。
     *
     * @param a     数组
     * @param n     数组长度
     * @param value 待查找的元素
     * @return value在数组a[]中的位置
     */
    public static int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value < a[mid]) {
                high = mid - 1;
            }
            if (value == a[mid]) {
                return mid;
            }
            if (value > a[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找(递归写法)
     */
    public static int binarySearchRecursive(int[] a, int value, int low, int high) {
        int mid = (low + high) / 2;
        if (value == a[mid]) {
            return mid;
        }
        if (value < a[mid]) {
            return binarySearchRecursive(a, value, low, mid - 1);
        }
        if (value > a[mid]) {
            return binarySearchRecursive(a, value, mid + 1, high);
        }
        return -1;
    }


    /**
     * 3。插值查找：基于二分查找算法，将查找点的选择改进为自适应选择。
     *
     * @param a     数组
     * @param value 待查找的元素
     * @param low   low
     * @param high  high
     * @return value在数组a[]中的位置
     */
    public static int insertionSearch(int[] a, int value, int low, int high) {
        int mid = low + (value - a[low]) / (a[high] - a[low]) * (high - low);
        if (value == a[mid]) {
            return mid;
        }
        if (value < a[mid]) {
            return insertionSearch(a, value, low, mid - 1);
        }
        if (value > a[mid]) {
            return insertionSearch(a, value, mid + 1, high);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        // 1.顺序查找
        System.out.println(sequenceSearch(a, 5, 3));

        // 2.二分查找
        System.out.println(binarySearch(a, 5, 3));

        // 2.二分查找(递归写法)
        System.out.println(binarySearchRecursive(a, 3, 0, a.length - 1));

        // 3.插值查找
        System.out.println(insertionSearch(a, 3, 0, a.length - 1));

        // 4.斐波那契查找

        // 5.1二叉树查找算法

        // 5.2平衡查找树之2-3查找树

        // 5.3平衡查找树之红黑树
    }
}

/*
 * 参考链接https://blog.csdn.net/fafawf/article/details/81457650
 */