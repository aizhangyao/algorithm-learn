package com.aiz.leetcode.competition;

import java.util.*;

/**
 * @ClassName Solution20210925
 * @Description 未完成
 * @Author Yao
 * @Date Create in 3:06 下午 2021/9/25
 * @Version 1.0
 */
public class Solution20210925 {
    // T1
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static Set<Integer> inorderTraversal(TreeNode root) {
        Set<Integer> results = new HashSet<>();
        inRecursive(root, results);
        return results;
    }

    private static void inRecursive(TreeNode node, Set<Integer> results) {
        if (node == null) {
            return;
        }
        inRecursive(node.left, results);
        results.add(node.val);
        inRecursive(node.right, results);
    }

    public static int numColor(TreeNode root) {
        Set<Integer> set = inorderTraversal(root);
        return set.size();
    }

    public static void init(TreeNode root) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
    }

    public static void main1(String[] args) {
        TreeNode root = new TreeNode(1);
        init(root);
        System.out.println(numColor(root));
    }


    // T2
    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        return null;
    }

    // T3
    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        return null;
    }

    public static Map<Integer, int[]> findEdgesRelations(int[][] edges, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < edges.length; j++) {
                if (edges[j][0] == i) {
                    set.add(edges[j][1]);
                }
                if (edges[j][1] == i) {
                    set.add(edges[j][0]);
                }
            }
            int[] edge = new int[set.size()];
            int index = 0;
            for (Integer s : set) {
                edge[index] = s;
                index++;
            }
            map.put(i, edge);
        }
        return map;
    }


    public static int[] executePlan(int[] plan, int[] cnt, int[] edges) {
        int num = plan[0];
        int idx = plan[1];
        System.out.print("场馆" + idx + "，执行" + num + "方案");
        if (idx == 0) {
            return cnt;
        }
        if (num == 1) {
            // 1.将编号为 idx 的场馆内的志愿者人数减半；
            // 1.将cnt中下标为idx的数字翻倍
            cnt[idx - 1] *= 2;
        }
        if (num == 2) {
            // 2.将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
            // 2.将cnt中下标在edges的数字 减去 下标为idx的数字
            for (int edge : edges) {
                cnt[edge] -= cnt[idx - 1];
            }
        }
        if (num == 3) {
            // 3.将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。
            // 3.将cnt中下标在edges的数字 加上 下标为idx的数字
            for (int edge : edges) {
                cnt[edge] += cnt[idx - 1];
            }
        }
        System.out.print("后：" + Arrays.toString(cnt));
        return cnt;
    }

    public static void main(String[] args) {
        // 记录了第 1 ~ n-1 个场馆的最终志愿者人数
        int[] finalCnt = {4, 13, 4, 3, 8};
        int n = finalCnt.length + 1;
        // 场馆之间的通道分布情况
        int[][] edges = {{0, 3}, {1, 3}, {4, 3}, {2, 3}, {2, 5}};
        Map<Integer, int[]> map = findEdgesRelations(edges, n);
        for (Integer key : map.keySet()) {
            int[] edge = map.get(key);
            System.out.println("场馆 " + key + ", 相邻的场馆有 = " + Arrays.toString(edge));
        }
        System.out.println();

        // 初始所有场馆的志愿者总人数
        int totalNum = 54;
        // 所有的调配信息，plans[i] = [num,idx] 表示第 i 天对编号 idx 的场馆执行了第 num 种调配方案
        int[][] plans = {{1, 1}, {3, 3}, {2, 5}, {1, 0}};
        for (int i = plans.length - 1; i >= 0; i--) {
            int[] edge = map.get(plans[i][1]);
            int day = i + 1;
            System.out.print("第" + day + "天，");
            executePlan(plans[i], finalCnt, edge);
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < finalCnt.length; i++) {
            sum += finalCnt[i];
        }
        System.out.print(totalNum - sum + " ");
        System.out.println(Arrays.toString(finalCnt));

    }

}
