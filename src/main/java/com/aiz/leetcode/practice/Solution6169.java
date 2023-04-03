package com.aiz.leetcode.practice;

/**
 * @ClassName Solution6169
 * @Description 最长优雅子数组
 * @Author ZhangYao
 * @Date Create in 11:28 2022/9/4
 * @Version 1.0
 */
public class Solution6169 {
    // 子数组 是数组中的一个 连续 部分。
    public int longestNiceSubarray(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] results = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if((nums[j-1] & nums[j]) == 0){
                    results[i-1] += 1;
                }else {
                    break;
                }
            }
        }
        int max = 1;
        for (int result : results) {
            max = Math.max(result,max);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(0&3);
//        System.out.println(3&8&48);
//        System.out.println(3&48);
//        System.out.println(8&48);

        test_1();
    }

    public static void test_1(){
        int[] nums = {744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664};
        Solution6169 solution6169 = new Solution6169();
        System.out.println(solution6169.longestNiceSubarray(nums));
    }

}
