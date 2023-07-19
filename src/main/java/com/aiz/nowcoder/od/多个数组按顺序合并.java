package com.aiz.nowcoder.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 多个数组按顺序合并
 * @description https://cxybb.com/article/weixin_41398052/106045155
 * @date Create in 10:04 2023/7/19
 */
public class 多个数组按顺序合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<String> list = new ArrayList<>();
        sc.nextLine(); // nextInt()会留下一个回车，需要消除,否则后边会出错
        while (!sc.hasNext("#")) {
            list.add(sc.nextLine());
        }
        List<String> result = mergeMultiRowArray(size, list);
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ",");
            }
        }
    }

    private static List<String> mergeMultiRowArray(int size, List<String> list) {
        List<String> result = new ArrayList<>();
        List<String[]> strings = new ArrayList<>();
        for (String str : list) {
            String[] split = str.split(",");
            strings.add(split);
        }
        int nowCount = 0;
        int count = getCount(size, strings);
        while (nowCount < count) {
            for (int i = 0; i < strings.size(); i++) {
                for (int j = nowCount * size; j < (nowCount + 1) * size && j < strings.get(i).length; j++) {
                    result.add(strings.get(i)[j]);
                }
            }
            nowCount++;
        }
        return result;
    }

    private static int getCount(int size, List<String[]> strings) {
        int maxSize = 0;
        for (String[] string : strings) {
            maxSize = Math.max(string.length, maxSize);
        }
        return maxSize % size == 0 ? maxSize / size : maxSize / size + 1;
    }

}
/*
test data
3
2,5,6,7,9,5,7
1,7,4,3,4
4,5,7,1,3,8
#
*/
