package com.aiz.lc.offer.day18;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer55
 * @description 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * @date Create in 23:03 2023/4/23
 */
public class SolutionOffer55I {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * answer1 : 二叉树
     */
}
