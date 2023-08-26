package com.aiz.leetcode.top_interview_150;

import com.aiz.base.tree.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 路径总和
 * @description https://leetcode.cn/problems/path-sum/
 * @date Create in 11:58 2023/8/25
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.init(new int[]{5, 4, 8, 11, TreeNode.NULL, 13, 4, 7, 2, TreeNode.NULL, TreeNode.NULL, TreeNode.NULL, 1});
        assert hasPathSum(root, 22);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.init(new int[]{1, 2, 3});
        assert !hasPathSum(root, 5);
    }

    @Test
    public void test4() {
        TreeNode root = null;
        assert !hasPathSum(root, 0);
    }
}
