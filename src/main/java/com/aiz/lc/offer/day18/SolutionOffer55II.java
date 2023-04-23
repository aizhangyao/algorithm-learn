package com.aiz.lc.offer.day18;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer55II
 * @description 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 * @date Create in 23:13 2023/4/23
 */
public class SolutionOffer55II {
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

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced((root.right));
    }

    public int height(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * answer1 : 二叉树
     */
}
