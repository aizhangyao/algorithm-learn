package com.aiz.lc.offer.utils;

import java.util.LinkedList;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TreeUtil
 * @description TreeUtil
 * @date Create in 16:06 2023/4/17
 */
public class TreeNode {
    /**
     * Definition for a binary tree node.
     */
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

    /**
     * 当遇到二叉树的时候一般输入是以数组的形式给出，不方便调试，因此本文总结一下如何将数组转换为二叉树结构，以方便打印调试过程。
     */

    /**
     * 从数组的某个位置的元素开始生成树
     */
    public static TreeNode createTree(Integer[] array, int start) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[start]);

        int leftNode = start >> 2 + 1;
        int rightNode = start >> 2 + 2;

        if (leftNode > array.length - 1) {
            root.left = null;
        } else {
            root.left = createTree(array, leftNode);
        }
        if (rightNode > array.length - 1) {
            root.right = null;
        } else {
            root.right = createTree(array, rightNode);
        }
        return root;
    }

    public static TreeNode getTreeNode(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        LinkedList<TreeNode> subTree = new LinkedList<>();
        subTree.push(head);
        for (int i = 1; i < nums.length; i++) {
            if (!subTree.isEmpty()) {
                TreeNode cur = subTree.pop();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    subTree.add(cur.left);
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
                if (nums[i] != null) {
                    cur.right = new TreeNode(nums[i]);
                    subTree.add(cur.right);
                }

            } else {
                break;
            }
        }
        return head;
    }

}
