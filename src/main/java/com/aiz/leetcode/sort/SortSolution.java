package com.aiz.leetcode.sort;

/**
 * @ClassName SortSolution
 * @Description 排序算法
 * @Author Yao
 * @Date Create in 11:46 下午 2021/6/16
 * @Version 1.0
 */
public class SortSolution {

    /**
     * 1。冒泡排序：它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 2。选择排序：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 3。插入排序：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1;
            int current = array[i];
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        // 1.冒泡排序
        int[] bubbleArray = bubbleSort(array);
        printArray(bubbleArray);

        // 2.选择排序
        int[] selectionArray = selectionSort(array);
        printArray(selectionArray);

        // 3.插入排序
        int[] insertionArray = insertionSort(array);
        printArray(insertionArray);

        // 4.希尔排序

        // 5.归并排序

        // 6.快速排序

        // 7.堆排序

        // 8.计数排序

        // 9.桶排序

        // 10.基数排序
    }

    /**
     * 打印数组
     *
     * @param array 需要打印的数组
     */
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
/*
 * 参考链接：https://blog.csdn.net/weixin_41190227/article/details/86600821
 */