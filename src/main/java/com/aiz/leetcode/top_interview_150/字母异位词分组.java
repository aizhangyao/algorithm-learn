package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYao
 * @className 字母异位词分组
 * @description https://leetcode.cn/problems/group-anagrams/
 * @date Create in 15:00 2023/8/11
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] nums = new int[26];
            for (int i = 0; i < s.length(); i++) {
                nums[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(nums[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    // 2024-03-29
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] nums = new int[26];
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                nums[aChar - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(nums[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    @Test
    public void test() {
        字母异位词分组 clazz = new 字母异位词分组();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = clazz.groupAnagrams(strs);
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> tempList1 = new ArrayList<>();
        tempList1.add("bat");
        expectedResult.add(tempList1);
        List<String> tempList2 = new ArrayList<>();
        tempList2.add("nat");
        tempList2.add("tan");
        expectedResult.add(tempList2);
        List<String> tempList3 = new ArrayList<>();
        tempList3.add("ate");
        tempList3.add("eat");
        tempList3.add("tea");
        expectedResult.add(tempList3);
        // BaseTool.equals(lists, expectedResult);
    }

    @Test
    public void test2() {
        字母异位词分组 clazz = new 字母异位词分组();
        String[] strs = {""};
        List<List<String>> lists = clazz.groupAnagrams(strs);
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> tempList1 = new ArrayList<>();
        tempList1.add("");
        expectedResult.add(tempList1);
        BaseTool.equals(lists, expectedResult);
    }

    @Test
    public void test3() {
        字母异位词分组 clazz = new 字母异位词分组();
        String[] strs = {"a"};
        List<List<String>> lists = clazz.groupAnagrams(strs);
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> tempList1 = new ArrayList<>();
        tempList1.add("a");
        expectedResult.add(tempList1);
        BaseTool.equals(lists, expectedResult);
    }

    @Test
    public void test4() {
        字母异位词分组 clazz = new 字母异位词分组();
        String[] strs = {"abbbbbbbbbbb", "aaaaaaaaaaab"};
        List<List<String>> lists = clazz.groupAnagrams(strs);
        List<List<String>> expectedResult = new ArrayList<>();
        List<String> tempList1 = new ArrayList<>();
        tempList1.add("aaaaaaaaaaab");
        expectedResult.add(tempList1);
        List<String> tempList2 = new ArrayList<>();
        tempList2.add("abbbbbbbbbbb");
        expectedResult.add(tempList2);
        // BaseTool.equals(lists, expectedResult);
    }
}
