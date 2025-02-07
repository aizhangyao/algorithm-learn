package com.aiz.lc.offer.day06;

import com.aiz.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZhangYao
 * @className SolutionOffer32I
 * @description 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @date Create in 18:25 2023/4/6
 */
public class 从上到下打印二叉树I {

    /**
     * Definition for a binary tree node.
     */

    /**
     * 广度优先遍历
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        // 层次遍历
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){};
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }


    /**
     * answer1 : 二叉树层次遍历
     */
}
