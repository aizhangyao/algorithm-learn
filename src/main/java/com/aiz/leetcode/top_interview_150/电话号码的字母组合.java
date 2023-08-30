package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZhangYao
 * @className 电话号码的字母组合
 * @description https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * @date Create in 17:39 2023/8/29
 */
public class 电话号码的字母组合 {
    List<String> combinations = new ArrayList<>();
    HashMap<Character, String> map = new HashMap();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtracking(digits, 0, new StringBuilder());
        return combinations;
    }

    private void backtracking(String digits, int index, StringBuilder combination) {
        if (combination.length() == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int j = 0; j < letters.length(); j++) {
            combination.append(letters.charAt(j));
            backtracking(digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }

    @Test
    public void test() {
        List<String> res = letterCombinations("23");
        List<String> expectedResult = Arrays.asList(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"});
        BaseTool.equals(res, expectedResult);
    }

    @Test
    public void test2() {
        List<String> res = letterCombinations("");
        List<String> expectedResult = Arrays.asList(new String[]{});
        BaseTool.equals(res, expectedResult);
    }

    @Test
    public void test3() {
        List<String> res = letterCombinations("2");
        List<String> expectedResult = Arrays.asList(new String[]{"a", "b", "c"});
        BaseTool.equals(res, expectedResult);
    }

    /*
    // 回溯算法框架
    List<Object> result;
    void backtracking(路径,选择列表){
        if(满足结束条件){
            result.add(路劲); //存放结果;
            return;
        }
        for (选择:本层集合中元素(树中节点孩子的数量就是集合的大小)){
            处理节点;
            backtracking(路径,选择列表);//递归
            回溯,撤销处理结果
        }
    }
     */
}
