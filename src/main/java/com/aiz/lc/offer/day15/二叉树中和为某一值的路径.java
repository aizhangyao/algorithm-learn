package com.aiz.lc.offer.day15;

import com.aiz.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 二叉树中和为某一值的路径
 * @description 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @date Create in 15:57 2023/4/17
 */
public class 二叉树中和为某一值的路径 {
    List<List<Integer>> result = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return result;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

    public static void main(String[] args) {
        二叉树中和为某一值的路径 solutionOffer34 = new 二叉树中和为某一值的路径();
        /**
         *           5
         *    4            8
         *  11 null  13         4
         * 7 2    null null   5  1
         */
        Integer[] tree = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode treeNode = TreeNode.getTreeNode(tree);

        System.out.println(solutionOffer34.pathSum(treeNode, 22));
    }

    /**
     * answer1 : 回溯 深度优先
     * answer2 : 广度优先 todo
     */
}
