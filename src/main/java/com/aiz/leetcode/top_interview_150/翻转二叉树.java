package com.aiz.leetcode.top_interview_150;

import com.aiz.base.tree.TreeNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 翻转二叉树
 * @description https://leetcode.cn/problems/invert-binary-tree/
 * @date Create in 21:16 2023/8/24
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.init(new int[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode treeNode = invertTree(root);
        TreeNode expectedResult = TreeNode.init(new int[]{4, 7, 2, 9, 6, 3, 1});
        assert BaseTool.equals(treeNode, expectedResult);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.init(new int[]{2, 1, 3});
        TreeNode treeNode = invertTree(root);
        TreeNode expectedResult = TreeNode.init(new int[]{2, 3, 1});
        assert BaseTool.equals(treeNode, expectedResult);
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.init(new int[]{});
        TreeNode treeNode = invertTree(root);
        TreeNode expectedResult = TreeNode.init(new int[]{});
        assert BaseTool.equals(treeNode, expectedResult);
    }
}
