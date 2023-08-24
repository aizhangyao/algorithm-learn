package com.aiz.leetcode.top_interview_150;

import com.aiz.base.tree.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 二叉树的最大深度
 * @description https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @date Create in 18:53 2023/8/24
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.init(new int[]{3, 9, 20, TreeNode.NULL, TreeNode.NULL, 15, 7});
        int depth = maxDepth(node);
        assert depth == 3;
    }

    @Test
    public void test2() {
        TreeNode node = TreeNode.init(new int[]{1, TreeNode.NULL, 2});
        int depth = maxDepth(node);
        assert depth == 2;
    }

}
