package com.aiz.lc.offer.day16;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer61
 * @description 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @date Create in 10:22 2023/4/18
 */
public class SolutionOffer61 {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     */
    public boolean isStraight(int[] nums) {
        // 1~13
        boolean[] has = new boolean[14];
        int max = 1, min = 13;

        for (int i = 0; i <= nums.length - 1; i++) {
            int num = nums[i];
            if (num != 0) {
                if (has[num - 1]) {
                    return false;
                }
                max = Math.max(max, num);
                min = Math.min(min, num);
                has[num - 1] = true;
            }
        }
        return max - min <= 4;
    }

    public static void main(String[] args) {
        SolutionOffer61 solutionOffer61 = new SolutionOffer61();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solutionOffer61.isStraight(nums));


        int[] nums1 = new int[]{0, 0, 8, 5, 4};
        System.out.println(solutionOffer61.isStraight(nums1));

    }

    /**
     * answer1 : 除0以外没有重复值，最大值最小值差值小于4
     */
}
