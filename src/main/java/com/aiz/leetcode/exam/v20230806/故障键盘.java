package com.aiz.leetcode.exam.v20230806;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZhangYao
 * @className 故障键盘
 * @description https://leetcode.cn/contest/weekly-contest-357/problems/faulty-keyboard/
 *              https://leetcode.cn/problems/faulty-keyboard/description/
 * @date Create in 10:32 2023/8/6
 */
public class 故障键盘 {
    public String finalString(String s) {
        String res = new String();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'i') {
                res = handleStr(res);
            } else {
                res += chars[i];
            }
        }
        return res;
    }

    public String handleStr(String s) {
        String res = new String();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            res += chars[i];
        }
        return res;
    }


    // 2024-04-01
    public String finalString2(String s) {
        // 使用双端队列
        Deque<Character> q = new ArrayDeque<>();
        // 把反转看成是往字符串的头部添加字符
        boolean tail = true;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'i') {
                // 修改添加方向
                tail = !tail;
            } else if (tail) {
                // 在尾部添加
                q.addLast(aChar);
            } else {
                // 在头部添加
                q.addFirst(aChar);
            }
        }
        // gnstr
        StringBuilder ans = new StringBuilder();
        for (char c : q) {
            ans.append(c);
        }
        if (!tail) {
            ans.reverse();
        }
        return ans.toString();
    }

    @Test
    public void test() {
        故障键盘 clazz = new 故障键盘();
        String res = clazz.finalString("string");
        String expectedResult = "rtsng";
        assert BaseTool.equals(expectedResult, res);
    }
}
