package com.aiz.lc.offer.day15;

import com.aiz.lc.offer.utils.TreeNode;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer54
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @date Create in 23:12 2023/4/17
 */
public class SolutionOffer54 {
    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     */
    int maxK, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        //dfs
        orderTraversal(root);
        return maxK;
    }

    void orderTraversal(TreeNode cur) {
        if (cur == null || k <= 0) {
            return;
        }
        orderTraversal(cur.right);
        System.out.print("(" + k + "," + cur.val + ") ");
//        if (k == 0) {
//            return;
//        }
        if (--k == 0) {
            maxK = cur.val;
        }
        orderTraversal(cur.left);
    }

    public static void main(String[] args) {
        SolutionOffer54 solutionOffer54 = new SolutionOffer54();
        TreeNode root = TreeNode.getTreeNode(new Integer[]{3, 1, 4, null, 2});
        // 4
        System.out.println(solutionOffer54.kthLargest(root, 1));

        SolutionOffer54 solutionOffer54_1 = new SolutionOffer54();
        // 4
        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(solutionOffer54_1.kthLargest(root2, 3));
    }

    /**
     * answer1 : 中序遍历 + 提前返回
     */
}
