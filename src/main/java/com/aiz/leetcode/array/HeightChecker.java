package com.aiz.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName HeightChecker
 * @Description https://leetcode-cn.com/problems/height-checker/
 * @Author zhangyao
 * @Date Create in 20:12 2020/6/30 0030
 * @Version 1.0
 */
public class HeightChecker {
    /**
     * 我自己写的
     * @param heights 一组学生的身高
     * @return 最小必要移动人数
     */
    public int heightChecker(int[] heights) {
        final int lengthMax = 100;
        if (heights.length == 0 || heights.length > lengthMax) {
            return -1;
        }
        int num = 0;
        int[] hasOrders = Arrays.copyOf(heights, heights.length);
        //排序
        Arrays.sort(hasOrders);
        //统计
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != hasOrders[i]) {
                num++;
            }
        }
        return num;
    }

    /**
     * 别人家的孩子
     *
     * @param heights 一组学生的身高
     * @return 最小必要移动人数
     */
    public int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numsOne = new int[]{1, 1, 4, 2, 1, 3};
        int[] numsTwo = new int[]{5, 1, 2, 3, 4};
        int[] numsThree = new int[]{1, 2, 3, 4, 5};

        HeightChecker hc = new HeightChecker();
        System.out.println(hc.heightChecker(numsOne));//3
        System.out.println(hc.heightChecker(numsTwo));//5
        System.out.println(hc.heightChecker(numsThree));//0

        System.out.println(hc.heightChecker2(numsOne));//3
        System.out.println(hc.heightChecker2(numsTwo));//5
        System.out.println(hc.heightChecker2(numsThree));//0
    }
}
/**
 * 个人即时感悟--2020/6/30
 * 非递减-->也就是递增排序
 * 所以复制一个数组 给数组先排序 然后统计每一位置不同数量
 * <p>
 * 我的答案可能有点难看，看到评论区有O(n)的解法，使用到了计数排序。
 * <p>
 * 别人的思路：
 * 借用计数排序的思维，先统计出heights数组每个元素理论上的位置，再通过一次遍历得出与理论值不同的元素的数量即为结果。
 */