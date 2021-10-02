package com.aiz.nowcoder.practice;

/**
 * @ClassName NC105
 * @Description 二分查找-II
 * @Author Yao
 * @Date Create in 4:35 下午 2021/10/1
 * @Version 1.0
 */
public class NC105 {

    /**
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] nums, int target) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                while (mid != 0 && nums[mid - 1] == nums[mid]) {
                    --mid;
                }
                return mid;
            }
            if (nums[mid] > target) {
                high = mid -1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void test1() {
        int[] nums = {1, 2, 4, 4, 5};
        int target = 4;
        System.out.println(search(nums, target));
    }


    public static void test2() {
        int[] nums = {-2, 1, 2};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public static void main(String[] args) {
        // test1();
        test2();
    }
}
