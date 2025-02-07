package com.aiz.lc.offer.day18;

import com.aiz.base.tree.TreeNode;

/**
 * @author ZhangYao
 * @className 二叉树的深度I
 * @description 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * @date Create in 23:03 2023/4/23
 */
public class 二叉树的深度I {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * answer1 : 二叉树
     */
}
