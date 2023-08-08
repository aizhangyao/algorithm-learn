package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 加油站
 * @description https://leetcode.cn/problems/gas-station/
 * @date Create in 19:47 2023/8/7
 */
public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 计算油量总亏损，总亏损的后一个点就是起点，可以这么想，我们要在前面留下尽可能多的油给后的亏损的大户用。
        // 总亏损最大的下标
        int minIndex = 0;
        int remainSum = gas[0] - cost[0];
        int minRemainSum = remainSum;
        for (int i = 1; i < gas.length; i++) {
            remainSum += (gas[i] - cost[i]);
            if (remainSum <= minRemainSum) {
                minIndex = i;
                minRemainSum = remainSum;
            }
        }
        // 总和必须大于0
        if (remainSum < 0) {
            return -1;
        }
        return (minIndex + 1) % gas.length;
    }

    @Test
    public void test() {
        加油站 clazz = new 加油站();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int i = clazz.canCompleteCircuit(gas, cost);
        assert i == 3;
    }

    @Test
    public void test2() {
        加油站 clazz = new 加油站();
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        int i = clazz.canCompleteCircuit(gas, cost);
        assert i == -1;
    }

    @Test
    public void test3() {
        加油站 clazz = new 加油站();
        int[] gas = new int[]{7, 1, 0, 11, 4};
        int[] cost = new int[]{5, 9, 1, 2, 5};
        // 2, -8, -1, 7, -1
        int i = clazz.canCompleteCircuit(gas, cost);
        assert i == 3;
    }

    @Test
    public void test4() {
        加油站 clazz = new 加油站();
        int[] gas = new int[]{2, 0, 0, 0, 0, 0};
        int[] cost = new int[]{0, 1, 0, 0, 0, 0};
        int i = clazz.canCompleteCircuit(gas, cost);
        assert i == 0;
    }
}
