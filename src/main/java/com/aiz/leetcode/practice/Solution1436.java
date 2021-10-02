package com.aiz.leetcode.practice;

import java.util.*;

/**
 * @ClassName Solution1436
 * @Description 旅行终点站
 * @Author Yao
 * @Date Create in 5:11 下午 2021/10/1
 * @Version 1.0
 */
public class Solution1436 {
    public static String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        for (List<String> path : paths) {
            cities.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!cities.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

    public static void test1() {
        String[][] pathArray = {{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}};
        List<List<String>> paths = convert(pathArray);
        System.out.println(destCity(paths));
    }

    public static void test2() {
        String[][] pathArray = {{"B", "C"}, {"D", "B"}, {"C", "A"}};
        List<List<String>> paths = convert(pathArray);
        System.out.println(destCity(paths));
    }

    public static List<List<String>> convert(String[][] pathArray) {
        List<List<String>> paths = new ArrayList<>();
        for (String[] path : pathArray) {
            List<String> node = new ArrayList<>();
            node.add(path[0]);
            node.add(path[1]);
            paths.add(node);
        }
        return paths;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
