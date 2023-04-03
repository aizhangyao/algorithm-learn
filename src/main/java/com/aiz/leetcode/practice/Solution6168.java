package com.aiz.leetcode.practice;

/**
 * @ClassName Solution6168
 * @Description 恰好移动 k 步到达某一位置的方法数目
 * @Author ZhangYao
 * @Date Create in 11:10 2022/9/4
 * @Version 1.0
 */
public class Solution6168 {

    public int numberOfWays(int startPos, int endPos, int k) {
        if (endPos - startPos < k) {
            return 0;
        }
        if (endPos - startPos == k) {
            return 1;
        }

        // endPos - startPos 奇偶性需要和k一样
        if ((endPos - startPos + k ) % 2 == 1) {
            return 0;
        }


        return 0;
    }
}
