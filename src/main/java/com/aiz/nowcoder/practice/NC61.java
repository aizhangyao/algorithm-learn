package com.aiz.nowcoder.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NC61
 * @Description TODO
 * @Author Yao
 * @Date Create in 9:08 下午 2021/9/28
 * @Version 1.0
 */
public class NC61 {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[0];
    }

}
