package com.aiz.lc.offer.day07;

import com.aiz.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhangYao
 * @className 对称的二叉树
 * @description 剑指 Offer 28. 对称的二叉树
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * @date Create in 00:27 2023/4/7
 */
public class 对称的二叉树 {
    /**
     * Definition for a binary tree node.
     */

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


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                treeNodes.add(node);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            int i = 0;
            while (i < treeNodes.size() / 2) {
                TreeNode one = treeNodes.get(i);
                TreeNode two = treeNodes.get(treeNodes.size() - 1 - i);
                i++;
                if (one == null && two == null) {
                    continue;
                }
                if (one == null || two == null) {
                    return false;
                }
                if (one.val != two.val) {
                    return false;
                }
            }
            treeNodes.clear();
        }
        return true;
    }

    /**
     * answer1 : 广度优先遍历 递归
     * answer1 : 广度优先遍历 队列
     */
}
