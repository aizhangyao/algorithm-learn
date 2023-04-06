package com.aiz.lc.offer.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer28
 * @description 剑指 Offer 28. 对称的二叉树
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * @date Create in 00:27 2023/4/7
 */
public class SolutionOffer28 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    private boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode pn = queue.poll();
            TreeNode qn = queue.poll();
            if (pn == null && qn == null) {
                continue;
            }
            if ((pn == null || qn == null) || (pn.val != qn.val)) {
                return false;
            }
            queue.offer(pn.left);
            queue.offer(qn.left);

            queue.offer(pn.right);
            queue.offer(qn.right);
        }
        return true;
    }

    /**
     * answer1 : 广度优先遍历 递归
     * answer1 : 广度优先遍历 队列
     */
}
