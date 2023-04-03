package com.aiz.leetcode.practice;

/**
 * @ClassName Solution6167
 * @Description 检查相同字母间的距离
 * @Author ZhangYao
 * @Date Create in 10:35 2022/9/4
 * @Version 1.0
 */
public class Solution6167 {

    /**
     * 暴力 a -> 97
     * @param s 该字符串仅由小写英文字母组成，s 中的每个字母都 恰好 出现 两次
     * @param distance 下标从 0 开始、长度为 26 的的整数数组 distance
     * @return
     */
    public boolean checkDistances(String s, int[] distance) {
        // 在一个 匀整 字符串中，第 i 个字母的两次出现之间的字母数量是 distance[i]

        int[] w_1 = new int[26];
        int[] w_2 = new int[26];
        boolean[] flags = new boolean[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i]-'a';
            // 第一个
            if(!flags[index]){
                w_1[index ] = i;
                flags[index] = true;
            }
            // 第二次
            else {
                w_2[index] = i;

            }
        }

        for (int i = 0; i < distance.length; i++) {
            if(w_2[i] - w_1[i] -1 != distance[i] && flags[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        Solution6167 solution6167 = new Solution6167();
//        int[] distance = new int[26];
//        for (int i = 0; i < 26; i++) {
//            distance[i] = i;
//        }
//
//        boolean[] f = new boolean[26];
//        for (int i = 0; i < f.length; i++) {
//            System.out.println(f[i]);
//        }
        test_1();
        test_2();
    }


    public static void test_1(){
        String s = "abaccb";
        int[] distance = new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Solution6167 solution6167 = new Solution6167();
        System.out.println(solution6167.checkDistances(s,distance));
    }

    public static void test_2(){
        String s = "aa";
        int[] distance = new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Solution6167 solution6167 = new Solution6167();
        System.out.println(solution6167.checkDistances(s,distance));
    }


}
