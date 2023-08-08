package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author ZhangYao
 * @className N字形变换
 * @description https://leetcode.cn/problems/zigzag-conversion/
 * @date Create in 17:03 2023/8/8
 */
public class N字形变换 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] rows = new int[s.length()];
        for (int i = 0; i < rows.length; i++) {
            int y = i % (2 * numRows - 2);
            if (y < numRows) {
                rows[i] = y;
            } else {
                rows[i] = (2 * numRows - 2) - y;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (i == rows[j]) {
                    sb.append(chars[j]);
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        N字形变换 clazz = new N字形变换();
        String convert = clazz.convert("PAYPALISHIRING", 3);
        // P A Y P A L I S H I R I N G
        // 1 2 3 2 1 2 3 2 1 2 3 2 1 2
        /*
            P   A   H   N
            A P L S I I G
            Y   I   R
         */
        assert Objects.equals(convert, "PAHNAPLSIIGYIR");
    }

    @Test
    public void test2() {
        N字形变换 clazz = new N字形变换();
        String convert = clazz.convert("PAYPALISHIRING", 4);
        // P A Y P A L I S H I R I N G
        // 1 2 3 4 3 2 1 2 3 4 3 2 1 2
        /*
            P     I    N
            A   L S  I G
            Y A   H R
            P     I
         */
        assert Objects.equals(convert, "PINALSIGYAHRPI");
    }

    @Test
    public void test3() {
        N字形变换 clazz = new N字形变换();
        String convert = clazz.convert("A", 1);
        assert Objects.equals(convert, "A");
    }

}
