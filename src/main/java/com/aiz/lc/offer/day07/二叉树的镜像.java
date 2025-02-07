package com.aiz.lc.offer.day07;

import com.aiz.base.tree.TreeNode;

/**
 * @author ZhangYao
 * @className 二叉树的镜像
 * @description 剑指 Offer 27. 二叉树的镜像
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 * @date Create in 00:18 2023/4/7
 */
public class 二叉树的镜像 {
    /**
     * Definition for a binary tree node.
     */

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * answer1 : 每一个节点交换左右孩子
     */
}
